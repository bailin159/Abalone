package com.example.bailin.abalone.tools;

import android.app.Application;
import android.content.Context;

import com.example.bailin.abalone.tools.citylist.DBManager;

<<<<<<< HEAD
import io.vov.vitamio.Vitamio;
=======
import cn.bmob.v3.Bmob;
>>>>>>> feature/CPC-新闻进阶

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
<<<<<<< HEAD
        Vitamio.isInitialized(this);
=======
         mContext= this;
        // 初始化BmobSDK
        Bmob.initialize(this, "ac51df24e2f4feeca5b972599cb7a1a1");
>>>>>>> feature/CPC-新闻进阶
    }

    public static Context getContext() {
        return mContext;
    }
}
