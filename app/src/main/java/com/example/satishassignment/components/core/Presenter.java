package com.example.satishassignment.components.core;

import android.content.Context;

import com.example.satishassignment.model.Data;

import java.util.ArrayList;


/**
 * Created by Ashish on 28-09-2017.
 */

public class Presenter implements GetDataContract.Presenter, GetDataContract.onGetDataListener {
    private GetDataContract.View mGetDataView;
    private Intractor mIntractor;
    public Presenter(GetDataContract.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new Intractor(this);
    }
    @Override
    public void getDataFromURL(Context context, String url) {
        mIntractor.initDataCall(context,url);
    }

    @Override
    public void onSuccess(ArrayList<Data> datList) {
        mGetDataView.onGetDataSuccess(datList);
    }

    @Override
    public void onFailure(int message) {
        mGetDataView.onGetDataFailure(message);
    }
}
