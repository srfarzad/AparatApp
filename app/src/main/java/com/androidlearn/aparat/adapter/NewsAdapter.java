package com.androidlearn.aparat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.viewpager.widget.PagerAdapter;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.models.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends PagerAdapter {
    List<News> newsList;
    Context context;
    public NewsAdapter(Context context ,List<News> newsList){
        this.newsList=newsList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_row,null);

        AppCompatImageView  img_news= view.findViewById(R.id.img_news);

        container.addView(view, 0);
        News news = newsList.get(position);
        Picasso.get().load(news.getIcon())
                .placeholder(R.drawable.raymon)
                .into(img_news);



        return view;
    }
}
