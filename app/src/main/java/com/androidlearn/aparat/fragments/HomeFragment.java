package com.androidlearn.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.NewsAdapter;
import com.androidlearn.aparat.adapter.VideoAdapter;
import com.androidlearn.aparat.api.WebserviceCaller;
import com.androidlearn.aparat.models.IMessageListener;
import com.androidlearn.aparat.models.News;
import com.androidlearn.aparat.models.Video;

import java.util.List;


public class HomeFragment extends Fragment {

    WebserviceCaller webserviceCaller;
    RecyclerView recycler_best,recycler_special,recycler_new_videos;
    ProgressBar progress_best,progress_special,progress_new_videos;
    ViewPager pager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_best = view.findViewById(R.id.recycler_best);
        progress_best = view.findViewById(R.id.progress_best);
        recycler_special = view.findViewById(R.id.recycler_special);
        progress_special = view.findViewById(R.id.progress_special);
        recycler_new_videos = view.findViewById(R.id.recycler_new_videos);
        progress_new_videos = view.findViewById(R.id.progress_new_videos);
        pager = view.findViewById(R.id.pager);

        webserviceCaller = new WebserviceCaller();

        progress_best.setVisibility(View.VISIBLE);
        webserviceCaller.getBestVideos(new IMessageListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("","");
                progress_best.setVisibility(View.GONE);
                VideoAdapter adapter = new VideoAdapter(getActivity(),(List<Video>) responseMessage);
                recycler_best.setAdapter(adapter);
                recycler_best.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("","");
                progress_best.setVisibility(View.GONE);
            }
        });

        progress_special.setVisibility(View.VISIBLE);
        webserviceCaller.getSpecialVideos(new IMessageListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                progress_special.setVisibility(View.GONE);

                VideoAdapter adapter = new VideoAdapter(getActivity(),(List<Video>) responseMessage);
                recycler_special.setAdapter(adapter);
                recycler_special.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

            }

            @Override
            public void onFailure(String errorResponseMessage) {
                progress_special.setVisibility(View.GONE);
            }
        });



        //----


        progress_new_videos.setVisibility(View.VISIBLE);
        webserviceCaller.getNewVideos(new IMessageListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                progress_new_videos.setVisibility(View.GONE);

                VideoAdapter adapter = new VideoAdapter(getActivity(),(List<Video>) responseMessage);
                recycler_new_videos.setAdapter(adapter);
                recycler_new_videos.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

            }

            @Override
            public void onFailure(String errorResponseMessage) {
                progress_new_videos.setVisibility(View.GONE);
            }
        });


        webserviceCaller.getNews(new IMessageListener() {
            @Override
            public void onSuccess(Object responseMessage) {


                pager.setAdapter(new NewsAdapter(getActivity(),(List<News>) responseMessage));

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });








        return view;
    }
}

