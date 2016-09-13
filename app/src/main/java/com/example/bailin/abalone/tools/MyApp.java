package com.example.bailin.abalone.tools;

import android.app.Application;
import android.content.Context;

/**
 * Created by 白霖 on 16/8/15.
 */
public class MyApp extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
