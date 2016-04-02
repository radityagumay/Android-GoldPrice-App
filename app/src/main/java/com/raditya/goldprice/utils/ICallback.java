package com.raditya.goldprice.utils;

/**
 * Created by radityagumay on 3/29/2016.
 */
public interface ICallback<T> {

    public void onSuccess(T result);

    public void onError(Throwable throwable);
}
