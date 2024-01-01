package com.cysm.androidpractice.Gsonobject.gmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

    @SerializedName("email")
    public String email;
    @SerializedName("avatar")
    public String avatar;
}
