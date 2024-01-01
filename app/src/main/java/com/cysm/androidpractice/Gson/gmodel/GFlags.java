package com.cysm.androidpractice.Gson.gmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class GFlags implements Serializable {
 @SerializedName("flags")
 public Flag flag;

 @SerializedName("name")
 public Name name;
}

