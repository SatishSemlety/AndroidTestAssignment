package com.example.satishassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.satishassignment.R;
import com.example.satishassignment.model.Data;

import java.util.List;


public class TopListAdapter extends RecyclerView.Adapter<TopListAdapter.TopListViewHolder>
         {

    private Context context;
    private List<Data> topModelData;



    public TopListAdapter(Context context, List<Data> list) {
        this.context = context;
        this.topModelData = list;

    }


    public class TopListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title,tv_comment_count,tv_like_count;
        ImageView iv_image;
        public TopListViewHolder(View view) {
            super(view);
            iv_image = view.findViewById(R.id.list_image);
            tv_title=view.findViewById(R.id.list_title);
            tv_comment_count=view.findViewById(R.id.list_comment_count);
            tv_like_count=view.findViewById(R.id.list_like_count);
        }
    }

    @Override
    public TopListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list_item, parent, false);

        return new TopListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopListViewHolder holder, final int position) {
        final Data topDataClass = topModelData.get(position);
        holder.tv_title.setText(topDataClass.getTitle());
        holder.tv_like_count.setText(topDataClass.getVote_count());
        holder.tv_comment_count.setText(topDataClass.getComments_count());

        RequestOptions defaultImg = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(defaultImg)
                .load(topDataClass.getImage())
                .into(holder.iv_image);


    }

    @Override
    public int getItemCount() {
        return topModelData.size();
    }



}