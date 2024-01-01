package com.cysm.androidpractice.task.tmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
    @SerializedName("_id")
    public String _id;

    @SerializedName("name")
    public String name;

    @SerializedName("trips")
    public int trips;

    @SerializedName("airline")
    public List<Airline> airline;
}