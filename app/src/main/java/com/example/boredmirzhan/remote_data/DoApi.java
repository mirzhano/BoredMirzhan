package com.example.boredmirzhan.remote_data;
import com.example.boredmirzhan.models.ModelDo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DoApi {

    @GET("api/activity")
    Call<ModelDo> getActivities();
        @GET("/api/activity/{key}")
        Call<ModelDo>getActivityByKey(
                @Query("key") String key);
        @GET("/api/activity/{key}")
        Call<ModelDo> getActivityByPrice(
                @Query("price") double price);
        @GET("/api/activity?link")
        Call<ModelDo> getActivityByLink(
                @Query("link") String link);
        @GET("/api/activity/{key}")
        Call<ModelDo> getActivityByPrice(
                @Query("type") String type);

}
