package com.raditya.goldprice.network;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by radityagumay on 3/29/2016.
 */
public interface RestService {

    @GET("login")
    Call<Boolean> login();
}
