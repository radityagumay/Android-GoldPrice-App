package com.raditya.goldprice.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by radityagumay on 3/29/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        ButterKnife.bind(getActivityLayout());
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    public abstract Activity getActivityLayout();

    public abstract int getContentView();
}