package com.cysm.androidpractice.retrofit.rmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class RetrofitModel implements Serializable {
    @SerializedName("albumId")
    public Integer albumId;
    @SerializedName("id")
    public Integer id;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;
}
