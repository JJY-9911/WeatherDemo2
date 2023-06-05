package com.example.menu;


import static com.example.menu.Constant.MY_KEY;
import static com.example.menu.Constant.URL_CITY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.menu.adapter.CityManagerAdapter;
import com.example.menu.adapter.SearchListAdapter;
import com.example.menu.databinding.ActivityCityBinding;

import com.example.menu.dto.CityDTO;
import com.example.menu.item.CityManagerItem;

import com.example.menu.item.SearchListItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;

import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CityActivity extends AppCompatActivity {
    ActivityCityBinding binding;
    RecyclerView cityManagerRecycler;
    RecyclerView searchRecycler;
    List<CityManagerItem> cityMangerData;
    List<SearchListItem> searchData;
    CityManagerAdapter cityManagerAdapter;
    SearchListAdapter searchListAdapter;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.search_bottom_sheet,null);
        bottomSheetDialog.setContentView(view);

        searchRecycler = view.findViewById(R.id.search_Recycler);
        searchData = new ArrayList<>();
        /**从这里开始，用户随时可能点击按钮发送异步的网络请求，所以适配器的初始化等主线程的UI操作至此全部结束*/
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!searchData.isEmpty()) {
                    searchData.clear();
                }
                String location = binding.edit.getText().toString();
                searchCity(location);
                hideKeyboard();
            }
        });
    }
    public void searchCity(String location){
        final String TAG = "searchCity";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request  request = new Request.Builder().url(URL_CITY + location + MY_KEY).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG,"网络请求失败");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String str = response.body().string();
                    Log.d(TAG,"请求接口成功" + str);
                    Gson gson = new Gson();
                    CityDTO cityDTO = gson.fromJson(str,CityDTO.class);
                    if (cityDTO.getCode().equals("200")){
                        Log.d(TAG,"查询成功" + "code=" + cityDTO.getCode());
                        /**
                         * @param name 城市名，作为联想搜索列表的数据源
                         * @param cityId 天气接口的请求需要城市id
                         * */
                        for (int i = 0; i < cityDTO.getLocation().size(); i++) {
                            String name = cityDTO.getLocation().get(i).getName();
                            String cityId = cityDTO.getLocation().get(i).getId();
                            System.out.println(i + name + cityId);
                            searchData.add(new SearchListItem(name));
                            }
                    }else {
                        searchData.add(new SearchListItem("查询不到，请重新输入"));
                        Log.d(TAG,"请正确输入城市或区" + "code=" + cityDTO.getCode());
                    }
                    runOnUiThread(()-> {
                                searchListAdapter = new SearchListAdapter(CityActivity.this,searchData);
                                searchRecycler.setAdapter(searchListAdapter);
                                searchRecycler.setLayoutManager(new LinearLayoutManager(CityActivity.this));
                                bottomSheetDialog.show();
                            }
                    );
                }
            }
        });
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
