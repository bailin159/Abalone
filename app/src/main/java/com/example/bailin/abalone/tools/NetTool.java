package com.example.bailin.abalone.tools;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 白霖 on 16/9/13.
 */
public class NetTool {
    private Handler mHandler;

    public NetTool() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public <T> void getData(String url, final Class<T> tClass, final NetInterface<T> netInterface) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttp.getInstance().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                mHandler.post(new HandlerRunnable(gson.fromJson(response.body().string(), tClass), netInterface));
            }
        });

    }

    class HandlerRunnable<T> implements Runnable {
        T t;
        NetInterface<T> netInterface;

        public HandlerRunnable(T t, NetInterface<T> netInterface) {
            this.t = t;
            this.netInterface = netInterface;
        }

        @Override
        public void run() {
            netInterface.onSuccess(t);
        }
    }

    // 网络请求的接口，有成功方法， 有失败方法
    public interface NetInterface<T> {
        void onSuccess(T t); // 网络请求成功 返回的是解析完成的实体类
    }
}
