package com.androidlearn.aparat.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.VideoAdapter;
import com.androidlearn.aparat.database.VideoDatabase;
import com.androidlearn.aparat.databinding.FragmentFavoriteBinding;
import com.androidlearn.aparat.models.Video;


public class FavoriteFragment extends Fragment {


    FragmentFavoriteBinding binding;

    VideoDatabase database;


    public FavoriteFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        database = VideoDatabase.getInstance(getActivity());


        binding.recyclerFavorite.setAdapter(new VideoAdapter(getActivity(),database.idao().getVideoList()));

        binding.recyclerFavorite.setLayoutManager(new GridLayoutManager(getActivity(),2));

    }
}