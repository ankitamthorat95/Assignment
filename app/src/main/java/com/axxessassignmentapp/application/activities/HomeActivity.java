package com.axxessassignmentapp.application.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidnetworking.error.ANError;
import com.axxessassignmentapp.application.R;
import com.axxessassignmentapp.application.adapters.ImageRecyclerAdapter;
import com.axxessassignmentapp.application.interfaces.ApiStatusCallBack;
import com.axxessassignmentapp.application.models.Datum;
import com.axxessassignmentapp.application.models.Image;
import com.axxessassignmentapp.application.models.ImageListResponce;
import com.axxessassignmentapp.application.network.ImagesServices;
import com.axxessassignmentapp.application.utils.Utility;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = HomeActivity.class.getSimpleName();
    EditText et_search;
    ImageView iv_search;
    TextView tv_retry;
    RecyclerView rv_images;
    LinearLayout lyt_progress , no_connection , no_item_layout;
    Activity activity;
    private Datum[] mHolderList;
    ArrayList<Image>  mImageList = new ArrayList<>();
    private ImageRecyclerAdapter adapter;
    private String keyword = "cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activity = HomeActivity.this;
        bindView();
        initListener();
        GetImageResponceList(keyword);
    }

    private void initListener() {
        tv_retry.setOnClickListener(this);
        iv_search.setOnClickListener(this);
    }

    private void bindView() {
        et_search = findViewById(R.id.et_search);
        iv_search = findViewById(R.id.iv_search);
        rv_images = findViewById(R.id.rv_images);
        lyt_progress = findViewById(R.id.lyt_progress);
        no_connection = findViewById(R.id.no_connection);
        no_item_layout = findViewById(R.id.no_item_layout);
        tv_retry = findViewById(R.id.tv_retry);
    }


    private void GetImageResponceList(String keyword) {
        try {
            if (Utility.isNetworkAvailable(getApplicationContext())) {
                lyt_progress.setVisibility(View.VISIBLE);
                lyt_progress.setAlpha(1.0f);

                ImagesServices.getInstance(getApplicationContext()).FetchImages( keyword, new ApiStatusCallBack<ImageListResponce>() {
                    @Override
                    public void onSuccess(ImageListResponce listResponse) {
                        Log.e(TAG, "Success ==>" + listResponse.getData().toString());
                        if (listResponse.getSuccess()) {
                            lyt_progress.setVisibility(View.GONE);
                            mHolderList = listResponse.getData();
                            //BindList(mHolderList);
                            if (mHolderList.length>0) {
                                GetOnlyImageList(mHolderList);
                            } else {
                                lyt_progress.setVisibility(View.GONE);
                                no_connection.setVisibility(View.GONE);
                                no_item_layout.setVisibility(View.VISIBLE);
                                rv_images.setVisibility(View.GONE);
                                Utility.showErrorMessage(activity, "No Data Found !");
                            }
                        }else {
                            lyt_progress.setVisibility(View.GONE);
                            no_connection.setVisibility(View.GONE);
                            no_item_layout.setVisibility(View.VISIBLE);
                            rv_images.setVisibility(View.GONE);
                            Utility.showErrorMessage(activity, "No Data Found !");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        lyt_progress.setVisibility(View.GONE);
                        no_connection.setVisibility(View.GONE);
                        no_item_layout.setVisibility(View.VISIBLE);
                        rv_images.setVisibility(View.GONE);
                        Log.e(TAG, "onError: ", anError);
                        Utility.showErrorMessage(activity, "Server Error");
                    }

                    @Override
                    public void onUnknownError(Exception e) {
                        lyt_progress.setVisibility(View.GONE);
                        no_item_layout.setVisibility(View.VISIBLE);
                        rv_images.setVisibility(View.GONE);
                        Log.e(TAG, "onError: ", e);
                        //Utility.showErrorMessage(activity, e.getMessage());
                    }
                });
            } else {
                lyt_progress.setVisibility(View.GONE);
                no_connection.setVisibility(View.VISIBLE);
                rv_images.setVisibility(View.GONE);
                no_item_layout.setVisibility(View.GONE);
                Utility.showErrorMessage(activity, "Could not connect to the internet");
            }
        } catch (Exception ex) {
            lyt_progress.setVisibility(View.GONE);
            no_connection.setVisibility(View.VISIBLE);
            Log.e("exBRSACT", "" + ex);
            Utility.showErrorMessage(activity, ex.getMessage());
        }
    }

    private void GetOnlyImageList(Datum[] mHolderList) {
        mImageList.clear();
        for (Datum data: mHolderList) {
            if (data.getImages() != null){
            for (Image imageItem : data.getImages()) {
                mImageList.add(imageItem);
            }
            }
        }
        BindList(mImageList);
    }

    private void BindList(ArrayList<Image> imageArrayList) {
        no_item_layout.setVisibility(View.GONE);
        no_connection.setVisibility(View.GONE);
        rv_images.setVisibility(View.VISIBLE);
        rv_images.setLayoutManager(new GridLayoutManager(this, 4));
        rv_images.setItemAnimator(new DefaultItemAnimator());
        rv_images.setHasFixedSize(true);
        adapter = new ImageRecyclerAdapter(activity, imageArrayList,
                new ImageRecyclerAdapter.ItemClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("imageitem",imageArrayList.get(position));
                        Utility.launchActivity(activity,ImageDetailsActivity2.class,false,bundle);
                    }
                });
        rv_images.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_retry:
                GetImageResponceList(keyword);
                break;

            case R.id.iv_search:
                if (!et_search.getText().toString().equals("")){
                    keyword = et_search.getText().toString();
                    GetImageResponceList(keyword);
                    Utility.hideKeyboard(activity);
                }else {
                    Utility.showErrorMessage(activity, "Enter Image Topic..");
                }
                break;
        }
    }
}