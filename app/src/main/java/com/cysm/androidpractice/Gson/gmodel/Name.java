package com.cysm.androidpractice.Gson.gmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Name implements Serializable {
    @SerializedName("common")
    public String common;

}
