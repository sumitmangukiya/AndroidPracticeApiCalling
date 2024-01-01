package com.cysm.androidpractice.Https.hmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Todos implements Serializable {
    @SerializedName("userId")
    public int userId;
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("completed")
    public boolean completed;

}
