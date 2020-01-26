package com.example.satishassignment.components.core;

import android.content.Context;

import com.example.satishassignment.model.Data;

import java.util.ArrayList;

public interface GetDataContract {
    interface View{
        void onGetDataSuccess(ArrayList<Data> list);
        void onGetDataFailure(int status);
    }
    interface Presenter{
        void getDataFromURL(Context context, String url);
    }
    interface Interactor{
        void initDataCall(Context context, String url);

    }
    interface onGetDataListener{
        void onSuccess(ArrayList<Data> list);
        void onFailure(int status);
    }
}
