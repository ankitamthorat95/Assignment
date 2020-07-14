package com.axxessassignmentapp.application.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.axxessassignmentapp.application.interfaces.ApiStatusCallBack;
import com.axxessassignmentapp.application.models.ImageListResponce;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

public class ImagesServices {

    private static final String TAG = ImagesServices.class.getSimpleName();

    private Context context;

    public ImagesServices(Context context) {
        this.context = context;
    }

    @SuppressLint("StaticFieldLeak")
    private static ImagesServices instance;

    public static ImagesServices getInstance(Context context) {
        if (instance == null) {
            instance = new ImagesServices(context);
        }
        return instance;
    }

    public void FetchImages(String keyword , final ApiStatusCallBack apiStatusCallBack) {
        try {

            JSONObject jsonObject = new JSONObject();
            try{
                jsonObject.put("Authorization", "Client-ID 137cda6b5008a7c");
                jsonObject.put("Content-Type", "application/json");
            }catch (Exception e){

            }

            AndroidNetworking.get("https://api.imgur.com/3/gallery/search/1?q="+keyword)
                   // .addHeaders(jsonObject)
                    .addHeaders("Authorization","Client-ID 137cda6b5008a7c")
                    .setTag("test")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Gson gson = new Gson();
                         //   Log.e(TAG, "FetchImages: "+response );
                            TypeToken<ImageListResponce> outputResponse = new TypeToken<ImageListResponce>() {
                            };
                            ImageListResponce output = gson.fromJson(response.toString(), outputResponse.getType());
                            //Log.e("FetchBatchTransactions",output.toString());
                            apiStatusCallBack.onSuccess(output);
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.e(TAG, "onError: ",anError );
                            apiStatusCallBack.onError(anError);
                        }
                    });

        } catch (Exception ex) {
            Log.e(TAG, "onError: ",ex );
            apiStatusCallBack.onUnknownError(ex);
        }
    }
}
