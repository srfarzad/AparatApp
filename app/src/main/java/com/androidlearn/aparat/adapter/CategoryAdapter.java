package com.androidlearn.aparat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryVH> {

    Context context;
    List<Category> categoryList;
    public CategoryAdapter(Context context,List<Category> categoryList){

        this.context=context;
        this.categoryList=categoryList;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_row,null);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {

        Category category = categoryList.get(position);

        holder.txt_title.setText(category.getTitle());
        Picasso.get().load(category.getIcon()).into(holder.img_category);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryVH extends RecyclerView.ViewHolder{


        AppCompatImageView img_category;
        AppCompatTextView txt_title;

        public CategoryVH(@NonNull View itemView) {
            super(itemView);
            img_category = itemView.findViewById(R.id.img_category);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }

}
