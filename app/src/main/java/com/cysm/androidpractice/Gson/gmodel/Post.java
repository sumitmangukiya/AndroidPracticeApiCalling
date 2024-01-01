package com.cysm.androidpractice.Gson.gmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post implements Serializable {
 @SerializedName("id")
 public int id;
 @SerializedName("title")
 public String title;
}
