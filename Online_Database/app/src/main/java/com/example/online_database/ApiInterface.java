package com.example.online_database;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("comments")
    Call<List<Model>> getComment();
}
