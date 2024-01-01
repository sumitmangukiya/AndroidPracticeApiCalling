package com.cysm.androidpractice.task;

import com.cysm.androidpractice.task.tmodel.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
//    @GET("qfonapp-Data")
//    Call<ApiResponse> getData(@Query("page") int page, @Query("size") int size);

    @GET("qfonapp-passenger/?page=1&size=5")
    Call<ApiResponse> getData();
}

