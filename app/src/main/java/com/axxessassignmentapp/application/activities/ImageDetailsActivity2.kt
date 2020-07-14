package com.axxessassignmentapp.application.activities

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axxessassignmentapp.application.R
import com.axxessassignmentapp.application.adapters.CommentRecyclerAdapter
import com.axxessassignmentapp.application.models.CommentModel
import com.axxessassignmentapp.application.models.Image
import com.axxessassignmentapp.application.offline.CommentsDatabaseHelper
import com.axxessassignmentapp.application.utils.Utility
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import java.util.*

class ImageDetailsActivity2 : AppCompatActivity(), View.OnClickListener {

    var iv_back: ImageView? = null
    val tv_imageName: TextView? = null
    val iv_image: ImageView? = null
    var et_comment: EditText? = null
    var tv_post: TextView? = null
    var rv_comments: RecyclerView? = null
    var no_item_layout: LinearLayout? = null
    var mCommentList = ArrayList<CommentModel>()
    var pb_image: ProgressBar? = null

    var imageitem: Image? = null
    private var activity: ImageDetailsActivity2? = null
    private var commentsDatabaseHelper: CommentsDatabaseHelper? = null
    private var adapter: CommentRecyclerAdapter? = null
    private var imageArrayList: ArrayList<CommentModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        activity = this@ImageDetailsActivity2

        imageitem = intent.getParcelableExtra("imageitem")
        bindView()
        initListener()
        BindList()
    }

    private fun initListener() {
        tv_post!!.setOnClickListener(this)
        iv_back!!.setOnClickListener(this)
    }

    private fun bindView() {
        iv_back = findViewById(R.id.iv_back)
        val tv_imageName = findViewById<TextView>(R.id.tv_imageName)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        et_comment = findViewById(R.id.et_comment)
        tv_post = findViewById(R.id.tv_post)
        rv_comments = findViewById(R.id.rv_comments)
        no_item_layout = findViewById(R.id.no_item_layout)

        val pb_image = findViewById<ProgressBar>(R.id.pb_image)
        try {

            Glide.with(activity!!)
                    .load(imageitem!!.link)
                    .thumbnail(0.5f)
                    .override(200, 200)
                    .error(R.drawable.ic_photo)
                    .listener(object : RequestListener<Drawable?> {
                        override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable?>, isFirstResource: Boolean): Boolean {
                            pb_image.setVisibility(View.GONE)
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any, target: Target<Drawable?>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                            pb_image.setVisibility(View.GONE)
                            return false
                        }
                    })
                    .into(iv_image)

            tv_imageName.setText(imageitem!!.title.toString())
        } catch (e: Exception) {
        }
        commentsDatabaseHelper = CommentsDatabaseHelper(activity!!.applicationContext)
    }

    private fun BindList() {
        imageArrayList = commentsDatabaseHelper!!.GetComments(imageitem!!.id)
        rv_comments!!.layoutManager = LinearLayoutManager(activity)
        rv_comments!!.itemAnimator = DefaultItemAnimator()
        rv_comments!!.setHasFixedSize(true)
        adapter = CommentRecyclerAdapter(activity, imageArrayList,
                CommentRecyclerAdapter.ItemClickListener { view, position -> })
        rv_comments!!.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_post -> if (et_comment!!.text.toString() != "") {
                Utility.hideKeyboard(activity)
                val commentModel = CommentModel()
                commentModel.comment = et_comment!!.text.toString()
                commentModel.imageid = imageitem!!.id
                val result = commentsDatabaseHelper!!.saveComment(commentModel)
                if (result != 0L) {
                    Utility.showSuccessMessage(activity, "Comment Saved .")
                    et_comment!!.setText("")
                    BindList()
                }
            } else {
                Utility.showNormalMessage(activity, "Enter Comment!")
            }
            R.id.iv_back -> onBackPressed()
        }

    }

}