package com.cysm.androidpractice.retrofit;

import com.cysm.androidpractice.retrofit.rmodel.RetrofitModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

//    @GET("/photos")
    @GET("b/1S3N")
    Call<List<RetrofitModel>> getAllPhotos();
}