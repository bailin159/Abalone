package com.example.bailin.abalone.me;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.tools.MyApp;

import cn.bmob.v3.BmobUser;

/**
 * Created by CPC_272 on 16/9/13.
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {
    private Button loginBtn, gouOutBtn;
    private ImageView mineHeard;
    private TextView mineOpen;
    private BmobUser bmobUser;

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        loginBtn = bindView(R.id.login_btn);
        mineOpen = bindView(R.id.mine_open);
        mineHeard = bindView(R.id.mine_heard);
        gouOutBtn=bindView(R.id.goout_btn);
    }

    @Override
    public void onStart() {
        super.onStart();
        bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            //这里面有数据就执行了这个方法
            mineOpen.setText("爆娱新用户");
            //这个是JPG格式的照片有可能会报错
            mineHeard.setImageResource(R.mipmap.baoyu_wangzhi);
        }else{
            mineOpen.setText("未登录");
            //这个是JPG格式的照片有可能会报错
            mineHeard.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void initData() {
        bmobUser = BmobUser.getCurrentUser();
        if (bmobUser != null) {
            //这里面有数据就执行了这个方法
            mineOpen.setText("爆娱新用户");
            //这个是JPG格式的照片有可能会报错
            mineHeard.setImageResource(R.mipmap.baoyu_wangzhi);
        }else{
            mineOpen.setText("未登录");
            //这个是JPG格式的照片有可能会报错
            mineHeard.setImageResource(R.mipmap.ic_launcher);
        }
        loginBtn.setOnClickListener(this);
        gouOutBtn.setOnClickListener(this);
        mineOpen.setOnClickListener(this);
        mineHeard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                if (bmobUser != null) {
                    mineOpen.setText("爆娱新用户");
                    //这个是JPG格式的照片有可能会报错
                    mineHeard.setImageResource(R.mipmap.baoyu_wangzhi);
                }else{
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivity(intent);
                }
                break;
            case R.id.goout_btn:
                BmobUser.logOut();
                initData();
                Toast.makeText(MyApp.getContext(), "退出登入", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_open:
                if (bmobUser != null) {
                    mineOpen.setText("爆娱新用户");
                    //这个是JPG格式的照片有可能会报错
                    mineHeard.setImageResource(R.mipmap.baoyu_wangzhi);
                }else{
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivity(intent);
                }
                break;
            case R.id.mine_heard://头像
                if (bmobUser != null) {
                    mineOpen.setText("爆娱新用户");
                    //这个是JPG格式的照片有可能会报错
                    mineHeard.setImageResource(R.mipmap.baoyu_wangzhi);
                }else {
                    Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivity(intent1);
                }
                break;
        }
    }
}
