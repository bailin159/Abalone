package com.example.bailin.abalone.me;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by CPC_272 on 16/10/8.
 */
public class LogonChildActivity  extends BaseActivity implements View.OnClickListener {
    private EditText passWordET, authCodeET, userET;
    private ImageView destroy_image;
    private Button logonBtn;
    private SharedPreferences sp;
    private String mPhoneNum, mPassWord, mUser;
    private SharedPreferences.Editor editor;
    @Override
    protected int setLayout() {
        return R.layout.activity_child_logon;
    }

    @Override
    protected void initView() {
        userET = bindView(R.id.logonChild_user);//用户名
        destroy_image = bindView(R.id.desitroy_logon_img);
        passWordET = bindView(R.id.logonChild_passWord);//密码
        authCodeET =bindView(R.id.logonChild_authCode);
        logonBtn = bindView(R.id.finish_logon);
    }

    @Override
    protected void initData() {
        sp = this.getSharedPreferences("users", MODE_PRIVATE);
        editor = sp.edit();
        logonBtn.setOnClickListener(this);
        destroy_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.finish_logon:
             putSp();
                break;
            case R.id.desitroy_logon_img:
                finish();
                break;
        }
    }
    private void putSp() {

        if (authCodeET.getText().toString().equals("54272")){
            //定一个名字和密码
            String phone = userET.getText().toString();
            String password = passWordET.getText().toString();
            //创建用户
            BmobUser myUesr = new BmobUser();
            //获取用户名
            myUesr.setUsername(phone);
            //获取密码
            myUesr.setPassword(password);
            myUesr.signUp(new SaveListener<BmobUser>() {
                @Override
                public void done(BmobUser myUesr, BmobException e) {
                    if (e == null) {
                        Log.d("FragmentRegister", "注册好了");
                        Toast.makeText(LogonChildActivity.this, "注册好了", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d("FragmentRegister" + e.toString(), "注册失败");
                        Toast.makeText(LogonChildActivity.this, "注册失败了", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            Intent intent = getIntent();
            mPhoneNum = intent.getStringExtra("mPhoneNUme");
            mPassWord = passWordET.getText().toString();
            mUser = userET.getText().toString();
            editor.putString("account", mPhoneNum);
            editor.putString("passWord", mPassWord);
            editor.putString("user", mUser);
            editor.commit();
            finish();
        }else {
            Toast.makeText(this, ("请输入正确的验证码"), Toast.LENGTH_SHORT).show();
        }
    }
}
