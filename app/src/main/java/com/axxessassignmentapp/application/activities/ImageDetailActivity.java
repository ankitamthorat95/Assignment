package com.axxessassignmentapp.application.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.axxessassignmentapp.application.R;
import com.axxessassignmentapp.application.adapters.CommentRecyclerAdapter;
import com.axxessassignmentapp.application.adapters.ImageRecyclerAdapter;
import com.axxessassignmentapp.application.models.CommentModel;
import com.axxessassignmentapp.application.models.Image;
import com.axxessassignmentapp.application.offline.CommentsDatabaseHelper;
import com.axxessassignmentapp.application.utils.Utility;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


import java.util.ArrayList;

public class ImageDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_delete;
    ImageView iv_back;
    TextView tv_imageName;
    ImageView iv_image;
    ProgressBar pb_image;
    EditText et_comment;
    TextView tv_post;
    RecyclerView rv_comments;
    LinearLayout no_item_layout;
    ArrayList<CommentModel> mCommentList = new ArrayList<>();

    Image imageitem;
    private ImageDetailActivity activity;
    private CommentsDatabaseHelper commentsDatabaseHelper;
    private CommentRecyclerAdapter adapter;
    private ArrayList<CommentModel> imageArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        activity = ImageDetailActivity.this;

        imageitem = getIntent().getParcelableExtra("imageitem");
        bindView();
        initListener();
        BindList();
    }

    private void initListener() {
        tv_post.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_delete.setOnClickListener(this);
    }

    private void bindView() {
        iv_back = findViewById(R.id.iv_back);
        tv_imageName = findViewById(R.id.tv_imageName);
        iv_image = findViewById(R.id.iv_image);
        et_comment = findViewById(R.id.et_comment);
        tv_post = findViewById(R.id.tv_post);
        rv_comments = findViewById(R.id.rv_comments);
        no_item_layout = findViewById(R.id.no_item_layout);
        iv_delete = findViewById(R.id.iv_delete);
        pb_image = findViewById(R.id.pb_image);

        try {
       /* Picasso.get()
                .load(imageitem.getLink())
                .placeholder(R.drawable.img_no_feed)
                .resize(100,100)
                .into(iv_image);*/

            Glide.with( activity )
                    .load( imageitem.getLink() )
                    .thumbnail( 0.5f )
                    .override( 200, 200 )
                    .error(R.drawable.ic_photo)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            pb_image.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            pb_image.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into( iv_image );


            tv_imageName.setText(imageitem.getTitle().toString());
        }catch (Exception   e){

        }
         commentsDatabaseHelper = new CommentsDatabaseHelper(activity.getApplicationContext());
    }


    private void BindList() {
        imageArrayList = commentsDatabaseHelper.GetComments(imageitem.getID());

        rv_comments.setLayoutManager(new LinearLayoutManager(activity));
        rv_comments.setItemAnimator(new DefaultItemAnimator());
        rv_comments.setHasFixedSize(true);
        adapter = new CommentRecyclerAdapter(activity, imageArrayList,
                new CommentRecyclerAdapter.ItemClickListener() {
                    @Override
                    public void onClick(View view, int position) {

                    }
                });
        rv_comments.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_post:
                if (!et_comment.getText().toString().equals("")) {
                    Utility.hideKeyboard(activity);
                    CommentModel commentModel = new CommentModel();
                    commentModel.setComment(et_comment.getText().toString());
                    commentModel.setImageid(imageitem.getID());

                    long result = commentsDatabaseHelper.saveComment(commentModel);
                    if (result!=0){
                        Utility.showSuccessMessage(activity,"Comment Saved .");
                        et_comment.setText("");
                        BindList();
                    }
                }else {
                    Utility.showNormalMessage(activity,"Enter Comment!");
                }
                break;

            case R.id.iv_back:
                onBackPressed();
                break;

        }
    }
}