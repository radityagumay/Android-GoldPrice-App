package com.raditya.goldprice.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raditya.goldprice.R;
import com.raditya.goldprice.base.BaseFragment;
import com.raditya.goldprice.network.model.response.GoldResponse;
import com.raditya.goldprice.ui.interactor.GoldPresenterImpl;
import com.raditya.goldprice.ui.presenter.GoldPresenter;
import com.raditya.goldprice.ui.view.GoldView;

import rx.Observable;

/**
 * Created by raditya.gumay on 02/04/2016.
 */
public class GoldFragment extends BaseFragment implements
        GoldView {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private GoldPresenter mPresenter;
    private Context mContext;

    public GoldFragment() {
    }

    public static GoldFragment newInstance(int sectionNumber) {
        GoldFragment fragment = new GoldFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new GoldPresenterImpl(mContext, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_main;
    }

    public void onCallService() {
        mPresenter.onCallGoldRepository();
    }

    @Override
    public void onResultGoldResponse(GoldResponse response) {
        Log.d("RADITYA GUMAY", "Hello");
    }

    @Override
    public void onDestroy() {
        this.mPresenter.onDestroy();
        super.onDestroy();
    }
}
