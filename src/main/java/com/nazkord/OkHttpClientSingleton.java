package com.nazkord;

import okhttp3.OkHttpClient;

public class OkHttpClientSingleton {

    private static okhttp3.OkHttpClient okHttpClient;

    public static OkHttpClient getOkHttpClient(){
        if(okHttpClient == null){
            synchronized (OkHttpClientSingleton.class) {
                if(okHttpClient == null){
                    okHttpClient = new okhttp3.OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
}
