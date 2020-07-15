package com.axxessassignmentapp.application.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.axxessassignmentapp.application.R;
import com.axxessassignmentapp.application.models.Image;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


import java.util.ArrayList;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.MemberListViewHolder> {

    private Context context;
    ArrayList<Image> imageHolders;
    private ItemClickListener itemClickListener;
    int status = 1;
    protected RequestManager glideManager; //make glideManager keeping

    public ImageRecyclerAdapter(Context context, ArrayList<Image> imageHolders, ItemClickListener itemClickListener) {
        this.context = context;
        this.imageHolders = imageHolders;
        this.itemClickListener = itemClickListener;
        glideManager = Glide.with(context);
    }


    public void filterList(ArrayList<Image> filterdNames) {
        this.imageHolders = filterdNames;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public MemberListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new MemberListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MemberListViewHolder holder, final int position) {

        final Image item = imageHolders.get(position);

        glideManager
                .load(item.getLink() )
                .fitCenter()
                .override(60, 60)
                .error(R.drawable.img_no_feed)
                .placeholder(R.drawable.img_no_feed)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.pb_image.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.pb_image.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into( holder.iv_image );



    }

    @Override
    public int getItemCount() {
        return imageHolders.size();
    }

    public class MemberListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_image;
        ProgressBar pb_image;

        public MemberListViewHolder(View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            pb_image = itemView.findViewById(R.id.pb_image);

            iv_image.setImageDrawable(null);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.onClick(v, getAdapterPosition());
        }
    }

//endregion

}
