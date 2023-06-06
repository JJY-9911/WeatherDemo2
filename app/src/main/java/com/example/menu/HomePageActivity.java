package com.example.menu;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.security.identity.CipherSuiteNotSupportedException;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.menu.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private ActivityHomePageBinding binding;
    List<String> headList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mapLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this,CityActivity.class);
                startActivity(intent);
            }
        });
        try {
            headList = getIntent().getStringArrayListExtra("homePage");
            Log.d("getStringArrayListExtra", headList.toString());

            headList = getIntent().getStringArrayListExtra("homePage");
            binding.headCity.setText(headList.get(0));
            binding.headTemperature.setText(headList.get(1));
            binding.headText.setText(headList.get(2));
            Log.d("head", "用户设置了地区" + headList.toString());
        }catch (Exception e){
        e.printStackTrace();
    }
    }
}