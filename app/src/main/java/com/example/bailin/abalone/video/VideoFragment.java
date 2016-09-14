package com.example.bailin.abalone.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;

/**
 * Created by 刘士壬 on 16/9/13.
 *
 */

public class VideoFragment extends BaseFragment {

    private EditText areaEt;// 地区
    private String areaUrl;// 地区URL

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        areaEt = bindView(R.id.video_area_et);
        initRecentlyFilm();
    }




    @Override
    protected void initData() {
        areaEt.setText("大连");
        areaUrl = areaEt.getText().toString();
       // String recentlyUrl =
    }

    private void initRecentlyFilm() {

        areaEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                areaUrl = areaEt.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }









}

