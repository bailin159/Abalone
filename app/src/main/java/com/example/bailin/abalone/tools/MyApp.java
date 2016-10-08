package com.example.bailin.abalone.tools;

import android.app.Application;
import android.content.Context;

import com.example.bailin.abalone.tools.citylist.DBManager;

import cn.bmob.v3.Bmob;

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
         mContext= this;
        // 初始化BmobSDK
        Bmob.initialize(this, "ac51df24e2f4feeca5b972599cb7a1a1");
    }

    public static Context getContext() {
        return mContext;
    }
}
