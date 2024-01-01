package com.cysm.androidpractice.task.tmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Airline implements Serializable {
    @SerializedName("_id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("country")
    public String country;
    @SerializedName("logo")
    public String logo;
    @SerializedName("slogan")
    public String slogan;
    @SerializedName("head_quarters")
    public String headQuarters;
    @SerializedName("website")
    public String website;
    @SerializedName("established")
    public String established;
}



