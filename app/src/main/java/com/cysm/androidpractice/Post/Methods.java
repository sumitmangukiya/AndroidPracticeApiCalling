package com.cysm.androidpractice.Post;

import com.cysm.androidpractice.Post.pModel.Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Methods {

    @FormUrlEncoded
    @POST("/api/users")
    Call<Model> getUserData(@Field("name")String name, @Field("job") String job);
}