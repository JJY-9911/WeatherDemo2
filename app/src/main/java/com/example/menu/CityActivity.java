package com.example.menu;


import static com.example.menu.Constant.MY_KEY;
import static com.example.menu.Constant.URL_CITY;
import static com.example.menu.Constant.URL_WEATHER_7;
import static com.example.menu.Constant.URL_WEATHER_NOW;
import static com.example.menu.Constant.URL_WEATHER_hour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.menu.adapter.CityManagerAdapter;
import com.example.menu.adapter.SearchListAdapter;
import com.example.menu.databinding.ActivityCityBinding;

import com.example.menu.dto.CityDTO;
import com.example.menu.dto.HomePageDTO;
import com.example.menu.dto.HourlyItem;
import com.example.menu.dto.WeatherHourDTO;
import com.example.menu.dto.WeatherNowDTO;
import com.example.menu.dto.WeatherSevenDTO;
import com.example.menu.item.CityManagerItem;

import com.example.menu.item.SearchListItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.resources.TextAppearanceFontCallback;
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
    /**已添加的城市模块*/
    List<CityManagerItem> cityMangerData = new ArrayList<>();
    /**搜索联想列表*/
    List<SearchListItem> searchData = new ArrayList<>();
    /**主页最上方的大字*/
    private List<String> headList;
    private List<HourlyItem> hourlyList = new ArrayList<>();
    private List<String> dailyList;
    CityManagerAdapter cityManagerAdapter;
    SearchListAdapter searchListAdapter;
    BottomSheetDialog bottomSheetDialog;
    private String name;
    private String cityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.search_bottom_sheet,null);
        bottomSheetDialog.setContentView(view);

        searchRecycler = view.findViewById(R.id.search_Recycler);

        /**从这里开始，用户随时可能点击按钮发送异步的网络请求，所以适配器的初始化等主线程的UI操作至此全部结束*/
        binding.edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    if(!searchData.isEmpty()){
                        searchData.clear();
                    }
                    String location = binding.edit.getText().toString();
                    searchCity(location);
                    hideKeyboard();
                    return true;
                }
                return false;
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
                         * @param name 城市名或者区名，作为联想搜索列表的数据源
                         * @param cityId 天气接口的请求需要城市id
                         * */
                        for (int i = 0; i < cityDTO.getLocation().size(); i++) {
                            name = cityDTO.getLocation().get(i).getName();
                            cityId = cityDTO.getLocation().get(i).getId();
                            Log.d(TAG, "" + i + name + cityId);
                            searchData.add(new SearchListItem(name,cityId));
                        }
                    }else {
                        searchData.add(new SearchListItem("查询不到，请重新输入","404"));
                    }
                    runOnUiThread(()-> {
                        SearchListAdapter.OnItemClickListener onItemClickListener = position -> {
                            String selectId = searchData.get(position).getId();
                            String selectCity = searchData.get(position).getName();
                            Log.d("选择城市", selectId + selectCity);
                            getWeather(selectId,selectCity);
                        };
                        searchListAdapter = new SearchListAdapter(CityActivity.this,searchData);
                        searchListAdapter.setOnItemClickListener(onItemClickListener);
                        searchRecycler.setAdapter(searchListAdapter);
                        searchRecycler.setLayoutManager(new LinearLayoutManager(CityActivity.this));
                        bottomSheetDialog.show();
                    }
                    );
                }
            }
        });
    }

    public void getWeather(String selectId,String cityName){
        final String TAG = "getWeather";
        Request request1 = new Request.Builder().url(URL_WEATHER_NOW + selectId + MY_KEY).build();
        Request request2 = new Request.Builder().url(URL_WEATHER_hour + selectId + MY_KEY).build();
        Request request3 = new Request.Builder().url(URL_WEATHER_7 + selectId + MY_KEY).build();

        getNow(request1,cityName);
        getHourly(request2);
        getSeven(request3);

        Intent intent = new Intent(CityActivity.this,HomePageActivity.class);

    }

    public void getNow(Request request,String cityName){
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("getNow","网络请求失败");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String str = response.body().string();
                    Log.d("getWeather","请求实时天气接口成功" + str);
                    Gson gson = new Gson();
                    WeatherNowDTO weatherNowDTO = gson.fromJson(str,WeatherNowDTO.class);
                    if(weatherNowDTO.getCode().equals("200")){
                        Log.d("getNow","查询成功" + "code=" + weatherNowDTO.getCode());
                        /**
                         * @param headList 主页上方的大字
                         * @param temp 气温
                         * @param text 描述多云等
                         * */
                        String temp = weatherNowDTO.getNow().getTemp();
                        String text = weatherNowDTO.getNow().getText();
                        headList = new ArrayList<>();
                        headList.add(cityName);
                        headList.add(temp);
                        headList.add(text);
                        Log.d("getWeather", cityName + "\n气温:" + temp + "\n描述:" + text);
                        /**获取主页数据源，跳转到主页*/
                        runOnUiThread(()->{
                            Intent intent = new Intent(CityActivity.this,HomePageActivity.class);
                            intent.putStringArrayListExtra("homePage",new ArrayList<>(headList));
                            startActivity(intent);
                        });
                    }
                }
            }
        });
    }
    public void getHourly(Request request){
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("getWeather","网络请求失败");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String str = response.body().string();
                    Log.d("getWeather","请求24h接口成功" + str);
                    Gson gson = new Gson();
                    WeatherHourDTO weatherHourDTO = gson.fromJson(str,WeatherHourDTO.class);

                    for (int i = 0; i < 24; i++) {
                        String time = weatherHourDTO.getHourly().get(i).getFxTime().substring(11,13);
                        String temp = weatherHourDTO.getHourly().get(i).getTemp();
                        hourlyList.add(new HourlyItem(time, temp));
                        Log.d("getWeather",  time + "\t气温：" + temp);
                    }
                }
            }
        });
    }
    public void getSeven(Request request){
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("getWeather","网络请求失败");
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String str = response.body().string();
                    Log.d("getWeather","请求7日接口成功" + str);
                    Gson gson = new Gson();
                    WeatherSevenDTO weatherSevenDTO = gson.fromJson(str,WeatherSevenDTO.class);
                }
            }
        });
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
