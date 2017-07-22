package com.onetwopunch.library_recycle_picasso_retro.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017-07-21.
 */

public class RetrofitClient {

    private  static Retrofit retrofit = null;

    public static Retrofit getClient(String baseURL)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
