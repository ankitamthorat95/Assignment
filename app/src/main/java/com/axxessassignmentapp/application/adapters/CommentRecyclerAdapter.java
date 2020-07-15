package com.axxessassignmentapp.application.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.axxessassignmentapp.application.R;
import com.axxessassignmentapp.application.models.CommentModel;
import com.axxessassignmentapp.application.models.Image;


import java.util.ArrayList;

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.MemberListViewHolder> {

    private Context context;
    ArrayList<CommentModel> commentHolders;
    private ItemClickListener itemClickListener;
    int status = 1;

    public CommentRecyclerAdapter(Context context, ArrayList<CommentModel> commentHolders, ItemClickListener itemClickListener) {
        this.context = context;
        this.commentHolders = commentHolders;
        this.itemClickListener = itemClickListener;
    }


    public void filterList(ArrayList<CommentModel> filterdNames) {
        this.commentHolders = filterdNames;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onClick(View view, int position);
    }

    @Override
    public MemberListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false);
        return new MemberListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MemberListViewHolder holder, final int position) {

        final CommentModel item = commentHolders.get(position);
        holder.tv_comment.setText(item.getComment());
    }

    @Override
    public int getItemCount() {
        return commentHolders.size();
    }

    public class MemberListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_comment;
        ImageView iv_delete;

        public MemberListViewHolder(View itemView) {
            super(itemView);
            tv_comment = itemView.findViewById(R.id.tv_comment);
            iv_delete = itemView.findViewById(R.id.iv_delete);
            iv_delete.setClickable(true);
            iv_delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) itemClickListener.onClick(v, getAdapterPosition());
        }
    }

//endregion

}
