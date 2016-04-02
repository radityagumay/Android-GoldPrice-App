package com.raditya.goldprice.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.raditya.goldprice.network.RestConstant;
import com.raditya.goldprice.network.RestHelper;
import com.raditya.goldprice.network.RestService;
import com.raditya.goldprice.network.model.response.GoldResponse;
import com.raditya.goldprice.utils.ICallback;

import java.io.StringReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by raditya.gumay on 02/04/2016.
 */
public class GoldPresenterManager {

    private Context mContext;
    private RestHelper mRestHelper;
    private RestService mService;
    private Subscription subscription;
    private Observable<GoldResponse> observable;

    public GoldPresenterManager(Context context) {
        this.mContext = context;
        this.mRestHelper = RestHelper.getInstance();
        this.mService = mRestHelper.getService();
    }

    public void onDestroy() {
        this.subscription.unsubscribe();
    }

    public void onCallRxGoldRepository(final ICallback<GoldResponse> callback) {
        observable = this.mService.getGoldData();
        subscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoldResponse>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("onError", e);
                    }

                    @Override
                    public void onNext(GoldResponse response) {
                        Timber.d("onNext", response);
                        if (callback != null) {
                            callback.onSuccess(response);
                        }
                    }
                });
    }

    public void onCallGoldRepository(final ICallback<GoldResponse> callback) {
        Retrofit retrofit = buildRetrofit();
        RestService service = retrofit.create(RestService.class);

        service.getGoldRepository()
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (callback != null) {
                            //callback.onSuccess(response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        if (callback != null) {
                            callback.onFailure(t);
                        }
                    }
                });
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(RestConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .build();
    }

    private Gson buildGson() {
        JsonReader reader = new JsonReader(new StringReader(result1));
        reader.setLenient(true);
        return new Gson().fromJson(reader, GoldResponse.class);
    }
}
