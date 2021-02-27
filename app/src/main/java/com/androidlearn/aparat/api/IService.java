package com.androidlearn.aparat.api;

import com.androidlearn.aparat.models.Category;
import com.androidlearn.aparat.models.News;
import com.androidlearn.aparat.models.Video;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {

    @GET("getNewVideos.php")
    Call<List<Video>> getNewVideos();

    @GET("getBestVideos.php")
    Call<List<Video>> getBestVideos();


    @GET("getSpecial.php")
    Call<List<Video>> getSpecialVideos();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String username , @Field("password") String password );

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(@Field("username") String username , @Field("password") String password );


    @GET("getNews.php")
    Call<List<News>> getNews();

    @GET("getCategory.php")
    Call<List<Category>> getAllCategories();

}
