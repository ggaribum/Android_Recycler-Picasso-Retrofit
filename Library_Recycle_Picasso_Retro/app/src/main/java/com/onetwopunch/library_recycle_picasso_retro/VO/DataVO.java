package com.onetwopunch.library_recycle_picasso_retro.VO;

/**
 * Created by Administrator on 2017-07-21.
 */


public class DataVO {
    String rank;
    String Nm;
    String url;

    //디폴트 생성자 만들어도 되는지 모르겠지만 일단 생성한다..
    public DataVO( )
    {
    }

    public DataVO(String rank, String name, String url) {
        this.rank = rank;
        this.Nm = name;
        this.url = url;
    }

    public String getRank() {
        return rank;
    }

    public String getName() {
        return Nm;
    }

    public String getUrl() {
        return url;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.Nm = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DataVO{" +
                "rank='" + rank + '\'' +
                ", name='" + Nm + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
