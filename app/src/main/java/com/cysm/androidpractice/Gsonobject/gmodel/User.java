package com.cysm.androidpractice.Gsonobject.gmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("data")
    public Data[] data;
}
