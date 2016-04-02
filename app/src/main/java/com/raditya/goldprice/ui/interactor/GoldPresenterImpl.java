package com.raditya.goldprice.ui.interactor;

import android.content.Context;
import android.util.Log;

import com.raditya.goldprice.manager.GoldPresenterManager;
import com.raditya.goldprice.network.RestHelper;
import com.raditya.goldprice.network.model.response.GoldResponse;
import com.raditya.goldprice.ui.presenter.GoldPresenter;
import com.raditya.goldprice.ui.view.GoldView;
import com.raditya.goldprice.utils.ICallback;

import rx.Observable;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by raditya.gumay on 02/04/2016.
 */
public class GoldPresenterImpl implements GoldPresenter {

    private GoldView mView;
    private Context mContext;
    private GoldPresenterManager mManager;

    public GoldPresenterImpl(Context context, GoldView view) {
        this.mView = view;
        this.mContext = context;
        this.mManager = new GoldPresenterManager(mContext);
    }

    @Override
    public void onCallGoldRepository() {
        this.mManager.onCallGoldRepository(new ICallback<GoldResponse>() {
            @Override
            public void onSuccess(GoldResponse response) {
                mView.onResultGoldResponse(response);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    @Override
    public void onCallGoldRxRepository() {
        this.mManager.onCallRxGoldRepository(new ICallback<GoldResponse>() {
            @Override
            public void onSuccess(GoldResponse response) {
                mView.onResultGoldResponse(response);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Timber.e("onFailure", throwable);
            }
        });
    }

    @Override
    public void onDestroy() {
        this.mManager.onDestroy();
    }
}
