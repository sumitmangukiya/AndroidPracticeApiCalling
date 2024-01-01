package com.cysm.androidpractice.tvshow.tmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Show implements Serializable {
    @SerializedName("name")
    public String name;

    @SerializedName("image")
    public Image image;

    @SerializedName("schedule")
    public Schedule schedule;
}
