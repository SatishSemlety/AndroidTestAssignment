package com.example.satishassignment.components.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.satishassignment.model.Data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Ashish on 28-09-2017.
 */

public class Intractor implements GetDataContract.Interactor{
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    ArrayList<Data> allDealsData = new ArrayList<>();


    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }
    @Override
    public void initDataCall(Context context, String urls) {

        Log.d("url",urls);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(urls, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d("res",response.toString());
                        try {
                            JSONObject dataObj=response.getJSONObject("deals");
                            JSONArray dataArray=dataObj.getJSONArray("data");

                            Log.d("data_array",""+dataArray.length());

                            if (dataArray.length()>0) {
                                Gson gson = new Gson();
                                Type listType = new TypeToken<List<Data>>() {
                                }.getType();

                                allDealsData = gson.fromJson(dataArray.toString(), listType);




                                mOnGetDatalistener.onSuccess(allDealsData);

                            }else {

                                mOnGetDatalistener.onFailure(201);
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("error",error.toString());
                mOnGetDatalistener.onFailure(400);
            }
        }
        ){
            @Override
            public Map<String,String> getHeaders() {
                HashMap<String,String> headers = new HashMap();
                headers.put("X-Desidime-Client","68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b" );
                return headers;
            }};

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);


    }


}
