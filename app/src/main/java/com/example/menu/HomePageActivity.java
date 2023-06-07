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
import com.example.menu.holder.DailyHolder;
import com.example.menu.holder.HourlyHolder;
import com.example.menu.item.DailyItem;
import com.example.menu.item.HourlyItem;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private ActivityHomePageBinding binding;
    List<String> headList = new ArrayList<>();
    List<HourlyItem>hourlyList = new ArrayList<>();
    List<DailyItem>dailyList = new ArrayList<>();

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
            headList = getIntent().getStringArrayListExtra("headList");
            Log.d("getStringArrayListExtra", headList.toString());

            headList = getIntent().getStringArrayListExtra("headList");
            hourlyList = HourlyHolder.getHourlyList();
            dailyList = DailyHolder.getDailyList();

            binding.headCity.setText(headList.get(0));
            binding.headTemperature.setText(headList.get(1));
            binding.headText.setText(headList.get(2));

            
            Log.d("head", "用户设置了地区" + headList.toString());
            Log.d("head", "24" + hourlyList.toString());
            Log.d("head", "7" + dailyList.toString());


        }catch (Exception e){
        e.printStackTrace();
    }
    }
}