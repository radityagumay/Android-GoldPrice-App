package com.raditya.goldprice.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by radityagumay on 3/29/2016.
 */
public class RestHelper<T> {

    private static RestHelper sInstance;
    private static final Object LOCK = new Object();

    private RestService service;

    public static RestHelper getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new RestHelper();
            }
        }
        return sInstance;
    }

    public RestHelper() {
        Retrofit retrofit = buildRetrofit();
        service = retrofit.create(RestService.class);
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(RestConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private Gson buildGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }

    public RestService getService() {
        return this.service;
    }
}
