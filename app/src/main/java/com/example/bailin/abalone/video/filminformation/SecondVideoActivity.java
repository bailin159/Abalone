package com.example.bailin.abalone.video.filminformation;

import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;

/**
 * Created by 刘士壬 on 16/9/20.
 */
public class SecondVideoActivity extends BaseActivity {

    private String webUrl;
    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.activity_second_video;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        webUrl = intent.getStringExtra("webUrl");
        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(webUrl);
        setContentView(webView);
    }

    @Override
    protected void initData() {

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
//            webView.goBack();
//        }
//        return false;
//
//    }

    //改写物理按键——返回的逻辑
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // TODO Auto-generated method stub
//        if(keyCode==KeyEvent.KEYCODE_BACK)
//        {
//            if(webView.canGoBack())
//            {
//                webView.goBack();//返回上一页面
//                return true;
//            }
//            else
//            {
//                System.exit(0);//退出程序
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
