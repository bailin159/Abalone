package com.example.bailin.abalone.me;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bailin.abalone.R;
import com.example.bailin.abalone.baseclass.BaseActivity;
import com.example.bailin.abalone.tools.MyApp;

/**
 * Created by CPC_272 on 16/10/8.
 */
public class LogonActivity extends BaseActivity implements View.OnClickListener {
    private EditText editText,phoneET;
    private Button getCaptchaBtn;
    private AlertDialog alertDialog;
    @Override
    protected int setLayout() {
        return R.layout.logon_activity;
    }

    @Override
    protected void initView() {
        editText =bindView(R.id.et_phoneNum);
        getCaptchaBtn = bindView(R.id.getcaptcha_btn);
        phoneET = bindView(R.id.et_phoneNum);
    }

    @Override
    protected void initData() {
        getCaptchaBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        showNotification();
        showPopWindow();
    }
    //AlertDialog的构造方法全部是Protected的，所以不能直接通过new一个AlertDialog来创建出一个AlertDialog。
    private void showPopWindow() {
        //Android详细的对话框AlertDialog.Builder
        AlertDialog.Builder dBuilder = new AlertDialog.Builder(MyApp.getContext());
        View dialogView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.dialogview, null);
        editText = (EditText) dialogView.findViewById(R.id.et_dialog);
        dBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (editText.getText().toString().equals("CPC272")) {
                    Intent intent = new Intent(MyApp.getContext(), LogonChildActivity.class);
                    intent.putExtra("mPhoneNUme",phoneET.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(MyApp.getContext(), ("验证码输入错误"), Toast.LENGTH_SHORT).show();
                }
            }
        });
        /**
         * setTitle ：为对话框设置标题
         *setIcon ：为对话框设置图标
         *setMessage：为对话框设置内容
         *setView ： 给对话框设置自定义样式
         *setItems ：设置对话框要显示的一个list，一般用于显示几个命令时
         *setMultiChoiceItems ：用来设置对话框显示一系列的复选框
         *setNeutralButton    ：普通按钮
         *setPositiveButton   ：给对话框添加"Yes"按钮
         *s etNegativeButton ：对话框添加"No"按钮
         *create ： 创建对话框
         *show ：显示对话框
         */
        dBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //此处要dismiss否则会将两个按钮保留
                alertDialog.dismiss();
            }
        });//此处不能show否则会将两个按钮保留
        dBuilder.setView(dialogView);
        //此处create
        alertDialog = dBuilder.create();//要创建一个AlertDialog，就要用到AlertDialog.Builder中的create()方法。
        alertDialog.show();
    }


    private void showNotification() {
        NotificationManager manager = (NotificationManager) MyApp.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(MyApp.getContext());
        builder.setContentTitle("爆娱向您发送注册验证码，请注意查收");
        builder.setContentText("您的36氪验证码为：54272");
        builder.setSmallIcon(R.mipmap.baoyu_loggg);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.baoyu_logo);
        builder.setLargeIcon(bitmap);
        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        manager.notify(0, notification);
    }
}
