package com.raditya.goldprice.network;

import com.raditya.goldprice.utils.ICallback;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by radityagumay on 3/29/2016.
 */
public class RestHelper {

    private static RestHelper sInstance;
    private static final Object LOCK = new Object();

    private RestService service;
    private Call call;

    public static RestHelper getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new RestHelper();
            }
        }
        return sInstance;
    }

    private RestHelper() {
        Retrofit retrofit = buildRetrofit();
        service = retrofit.create(RestService.class);
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(RestConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void cancel() {
        if (call != null) {
            this.call.cancel();
        }
    }

    /**
     * Do Async
     *
     * @param username
     * @param password
     * @param callback
     */
    public void login(String username,
                      String password,
                      final ICallback<Boolean> callback) {
        call = this.service.login();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
