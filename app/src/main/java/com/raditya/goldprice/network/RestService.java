package com.raditya.goldprice.network;

import com.raditya.goldprice.network.model.response.GoldResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by radityagumay on 3/29/2016.
 */
public interface RestService {

    @GET(RestConstant.GOLD)
    Call<String> getGoldRepository();

    @GET(RestConstant.GOLD)
    Observable<GoldResponse> getGoldData();
}
