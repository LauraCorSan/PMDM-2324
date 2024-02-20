package com.example.pmdm_2324.ut09.data_losSimpson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SimpsonsRepo {
    @GET("/quotes")
    Call <List<Personaje>> getCharacter(@Query("character") String character);

    /*GET("/api/users")
    public Call<UsersApiResponse> getUsers(@Query("per_page") int pageSize,
                                           @Query("page") int currentPage);*/
}
