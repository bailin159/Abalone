package com.example.bailin.abalone.me;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseFragment;
import com.example.bailin.abalone.main.MainActivity;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 登入
 * Created by CPC_272 on 16/10/8.
 */
public class LoginFragment extends BaseFragment {
    private EditText edit_account,edit_password;
    private Button btn_login;
    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }



    @Override
    protected void initView() {
        edit_password= bindView(R.id.edit_password);
        edit_account= bindView(R.id.edit_account);
        btn_login= bindView(R.id.Btn_login);
    }

    @Override
    protected void initData() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logPhone = edit_account.getText().toString();
                String logPass = edit_password.getText().toString();
                //获取 在想获得用户信息的地方
                BmobUser bmobUser = new BmobUser();
                bmobUser.setUsername(logPhone);
                bmobUser.setPassword(logPass);
                bmobUser.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(getContext(), "登录成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "登录失败了", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });

    }

}
