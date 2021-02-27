package com.androidlearn.aparat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.activity.VideoPlayerActivity;
import com.androidlearn.aparat.models.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoVH> {

    List<Video> videoList;
    Context contex;
    public VideoAdapter(Context context , List<Video> videoList){
        this.videoList=videoList;
        this.contex =context;
    }

    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.video_row,null);
        return new VideoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {

        Video video = videoList.get(position);

        holder.txt_title.setText(video.getTitle());

        Picasso.get().load(video.getIcon()).into(holder.img_video);

        holder.card_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(contex, VideoPlayerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("videoObj", video);
                contex.startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class VideoVH extends RecyclerView.ViewHolder {

        AppCompatImageView img_video;
        AppCompatTextView txt_title;
        CardView card_video;


        public VideoVH(@NonNull View itemView) {
            super(itemView);
            img_video= itemView.findViewById(R.id.img_video);
            txt_title= itemView.findViewById(R.id.txt_title);
            card_video= itemView.findViewById(R.id.card_video);
        }
    }

}
