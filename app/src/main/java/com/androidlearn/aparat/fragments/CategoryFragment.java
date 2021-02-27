package com.androidlearn.aparat.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.CategoryAdapter;
import com.androidlearn.aparat.api.WebserviceCaller;
import com.androidlearn.aparat.databinding.FragmentCategoryBinding;
import com.androidlearn.aparat.models.Category;
import com.androidlearn.aparat.models.IMessageListener;

import java.util.List;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;

    public CategoryFragment() {
        // Required empty public constructor
    }

    WebserviceCaller webserviceCaller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        webserviceCaller = new WebserviceCaller();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.progressBar.setVisibility(View.VISIBLE);
        webserviceCaller.getCategory(new IMessageListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                binding.progressBar.setVisibility(View.GONE);

                binding.recyclerCategory.setAdapter(new CategoryAdapter(getActivity(), (List<Category>) responseMessage));
                binding.recyclerCategory.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

            }

            @Override
            public void onFailure(String errorResponseMessage) {
                binding.progressBar.setVisibility(View.GONE);
            }
        });


    }
}