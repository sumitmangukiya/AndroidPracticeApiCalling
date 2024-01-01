package com.cysm.androidpractice.tvshow.tmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Schedule implements Serializable {
    @SerializedName("days")
    public String[] days;
}
