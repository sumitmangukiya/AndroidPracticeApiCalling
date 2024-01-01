package com.cysm.androidpractice.task.tmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {
    @SerializedName("data")
    public List<Data> data;
}
