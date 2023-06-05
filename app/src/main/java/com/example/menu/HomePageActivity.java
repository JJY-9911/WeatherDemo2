package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.menu.databinding.ActivityHomePageBinding;

public class HomePageActivity extends AppCompatActivity {
    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

    }


    @Override
    protected void onStart() {
        super.onStart();
        ImageView mapBtn = findViewById(R.id.map);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(HomePageActivity.this, CityActivity.class);
                HomePageActivity.this.startActivity(map, ActivityOptions.makeSceneTransitionAnimation(HomePageActivity.this).toBundle());
            }
        });
    }
}