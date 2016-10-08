package com.example.bailin.abalone.tools;

import android.app.Application;
import android.content.Context;

import com.example.bailin.abalone.tools.citylist.DBManager;

import io.vov.vitamio.Vitamio;

/**
 * Created by 白霖 on 16/8/15.
 */
public class MyApp extends Application {
    private static Context mContext;
    private DBManager dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        //导入数据库
        dbHelper = new DBManager(this);
        dbHelper.openDatabase();
        Vitamio.isInitialized(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
