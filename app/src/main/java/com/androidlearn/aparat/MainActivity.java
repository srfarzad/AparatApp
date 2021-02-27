package com.androidlearn.aparat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.androidlearn.aparat.activity.WebViewActivity;
import com.androidlearn.aparat.adapter.TabsAdapter;
import com.androidlearn.aparat.databinding.ActivityMainBinding;
import com.androidlearn.aparat.fragments.CategoryFragment;
import com.androidlearn.aparat.fragments.FavoriteFragment;
import com.androidlearn.aparat.fragments.HomeFragment;
import com.androidlearn.aparat.utils.Singleton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager(), fragmentList);
        binding.pager.setAdapter(adapter);

        binding.imgWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(intent);

            }
        });


        binding.bottomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){

                    case R.id.item_home :

                        binding.pager.setCurrentItem(0);
                        binding.bottomMenu.getMenu().getItem(0).setChecked(true);

                        break;
                    case R.id.item_category :
                        binding.pager.setCurrentItem(1);
                        binding.bottomMenu.getMenu().getItem(1).setChecked(true);
                        break;
                    case R.id.item_favorite :
                        binding.pager.setCurrentItem(2);
                        binding.bottomMenu.getMenu().getItem(2).setChecked(true);
                        break;



                }

                return false;
            }
        });


        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0 :
                        binding.bottomMenu.getMenu().getItem(0).setChecked(true);

                        break;
                    case  1:
                        binding.bottomMenu.getMenu().getItem(1).setChecked(true);
                        break;
                    case 2 :
                        binding.bottomMenu.getMenu().getItem(2).setChecked(true);
                        break;


                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Singleton singleton = Singleton.getInstance();


    }
}