package com.example.bailin.abalone.news;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;


/**
 * Created by CPC_272 on 16/9/19.
 */
public class NewsChildActivity  extends BaseActivity implements View.OnClickListener {
    private WebView webViewFirst;
     private ImageView back;
    @Override
    protected int setLayout() {
        return R.layout.news_child_activity;
    }

    @Override
    protected void initView() {
     webViewFirst=bindView(R.id.news_girl_web);
        back=bindView(R.id.newsChild_back);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String intents = intent.getStringExtra("url");
        webViewFirst.getSettings().setJavaScriptEnabled(true);
        webViewFirst.loadUrl(intents);
        webViewFirst.setWebViewClient(new WebViewClient(){
            //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
     back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.newsChild_back:
                finish();
                break;
        }
    }
}
