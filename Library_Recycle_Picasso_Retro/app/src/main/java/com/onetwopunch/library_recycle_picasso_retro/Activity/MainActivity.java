package com.onetwopunch.library_recycle_picasso_retro.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.onetwopunch.library_recycle_picasso_retro.UI.DataAdapter;
import com.onetwopunch.library_recycle_picasso_retro.R;
import com.onetwopunch.library_recycle_picasso_retro.Retrofit.RetrofitClient;
import com.onetwopunch.library_recycle_picasso_retro.Retrofit.RetrofitService;
import com.onetwopunch.library_recycle_picasso_retro.VO.DataVO;
import com.onetwopunch.library_recycle_picasso_retro.VO.GsonVO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL ="http://ec2-52-26-144-160.us-west-2.compute.amazonaws.com:3000";
    RecyclerView recyclerView;
    DataAdapter dataAdapter;
    ArrayList<DataVO> dataList;
    LinearLayoutManager linearLayoutManager;
    RetrofitClient client;
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList=new ArrayList<DataVO>();
        recyclerView =(RecyclerView) findViewById(R.id.Recycler_view);

        linearLayoutManager = new LinearLayoutManager(getApplication());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //dataList.add(new DataVO("1","2","http://www.gettyimagesgallery.com/Images/Thumbnails/1340/134050.jpg"));
        loadData();
    }
    //Retrofit을 이용한 데이터 읽어들어오는 부분.
    public void loadData()
    {
        Log.v("Checking loadData","여긴 들어간다");
        //RetrofitService 인터페이스를 어플리케이션에 제공하게 하기.
        service = RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);
        //enqueue를 호출하여 네트워크 Request를 처리 -> 콜백으로 앱에 알린다. 아래 두 메서드는 필수(자동)구현.

        service.loadAnswer().enqueue(new Callback<GsonVO>() {
            @Override
            public void onResponse(Call<GsonVO> call, Response<GsonVO> response) {
                if(response.isSuccessful())
                {
                    dataList=response.body().getAppList();
                 /*   Log.v("Checking retrofit",dataList.get(0).getName());
                    Log.v("Checking retrofit",dataList.get(1).getName());
                    Log.v("Checking retrofit",dataList.get(2).getName());*/

                    dataAdapter = new DataAdapter(getApplicationContext(),dataList);
                    //데이터 담기가 끝났으면 recyclerView에 setAdapter해주기
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(dataAdapter);

                }
                else
                {
                    //얘를 어떻게 출력할까..
                    int statusCode = response.code();
                }

            }

            @Override
            public void onFailure(Call<GsonVO> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });

    }
}
