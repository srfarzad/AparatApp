package com.androidlearn.aparat.api;

import android.util.Log;

import com.androidlearn.aparat.models.Category;
import com.androidlearn.aparat.models.IMessageListener;
import com.androidlearn.aparat.models.News;
import com.androidlearn.aparat.models.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {


    IService iService;

    public WebserviceCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);
    }

    public void getBestVideos(IMessageListener listener) {

        Call<List<Video>> call = iService.getBestVideos();

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage().toString());
            }
        });

    }


    public void getSpecialVideos(IMessageListener listener) {

        Call<List<Video>> call = iService.getSpecialVideos();

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage().toString());
            }
        });

    }


    public void getNewVideos(IMessageListener listener) {

        Call<List<Video>> call = iService.getNewVideos();

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage().toString());
            }
        });

    }

    public void getNews(IMessageListener listener) {

        Call<List<News>> call = iService.getNews();

        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString() + "");
            }
        });


    }

    public void getCategory(IMessageListener listener){

        Call<List<Category>> listCall= iService.getAllCategories();
        listCall.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
            listener.onFailure(t.getMessage().toString()+"");
            }
        });




    }


}
