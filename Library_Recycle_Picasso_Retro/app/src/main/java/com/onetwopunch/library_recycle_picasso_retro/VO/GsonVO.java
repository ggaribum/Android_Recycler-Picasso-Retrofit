package com.onetwopunch.library_recycle_picasso_retro.VO;

/**
 * Created by Administrator on 2017-07-21.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GsonVO {


    @SerializedName("appList")
    @Expose
    private ArrayList<DataVO> appList = null;



    public ArrayList<DataVO> getAppList() {
        return appList;
    }

    public void setAppList(ArrayList<DataVO> appList) {
        this.appList = appList;
    }
}
