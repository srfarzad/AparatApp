package com.androidlearn.aparat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.database.VideoDatabase;
import com.androidlearn.aparat.databinding.ActivityVideoPlayerBinding;
import com.androidlearn.aparat.models.Video;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

public class VideoPlayerActivity extends AppCompatActivity {

    ActivityVideoPlayerBinding binding;

    Bundle bundle;
    Video video;


    SimpleExoPlayer player;
    VideoDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        video= bundle.getParcelable("videoObj");

        database = VideoDatabase.getInstance(getApplicationContext());

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.txtTitle.setText(video.getTitle());

        player =  new SimpleExoPlayer.Builder(getApplicationContext()).build();
        binding.videoView.setPlayer(player);
        Uri uri = Uri.parse(video.getLink());
        MediaItem mediaItem = MediaItem.fromUri(uri);
        player.setMediaItem(mediaItem);

        player.prepare();
        player.play();


        if(database.idao().isExists(Integer.parseInt(video.getId()))){
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
        }else {
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }


        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(database.idao().isExists(Integer.parseInt(video.getId()))){

                    binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);

                    database.idao().deleteVideo(Integer.parseInt(video.getId()));

                }else {
                    binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
                    database.idao().insert(video);

                }





            }
        });





    }


    @Override
    protected void onStop() {
        super.onStop();
        if(player!=null){
            player.stop(true);
        }


    }
}