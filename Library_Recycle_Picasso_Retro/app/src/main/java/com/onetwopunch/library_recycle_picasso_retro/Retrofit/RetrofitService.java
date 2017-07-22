package com.onetwopunch.library_recycle_picasso_retro.Retrofit;

import com.onetwopunch.library_recycle_picasso_retro.VO.GsonVO;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017-07-21.
 */

public interface RetrofitService {
    @GET("/ordinary")
    Call<GsonVO> loadAnswer();
    //Call<GsonVO> loadAnswer(String tags); //tags에 /ordinary

}
