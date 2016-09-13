package com.example.bailin.abalone.tools;

import okhttp3.OkHttpClient;

/**
 * Created by 白霖 on 16/9/13.
 */
public class OkHttp {
    private static OkHttpClient okHttpClient;
    private OkHttp() {
    }

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (OkHttp.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
}
