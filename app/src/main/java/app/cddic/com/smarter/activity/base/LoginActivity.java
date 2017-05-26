package app.cddic.com.smarter.activity.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.db.DBHelper;
import app.cddic.com.smarter.entity.ConnectMsg;
import app.cddic.com.smarter.entity.MsgObject;
import app.cddic.com.smarter.utils.StaticClass;


/**
 * 项目名：  SmartApp
 * 包名：    app.cddic.com.smarter.ui
 * 文件名：  LoginActivity
 * 创建者：
 * 创建时间： 2017/3/24 15:13
 * 描述：
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private Button login;
    private Button toRegister;
    private Button noLogin;
    private Button forget;
    private EditText username;
    private EditText password;
    private TextView tv_loginFailed;
    private Intent intent;
    //用于测试
    private ConnectMsg connectMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
        initData();
    }

    private void initData() {
        intent = new Intent();
        connectMsg = new ConnectMsg();
        username.setText(mAPP.getUserName());
        password.setText(mAPP.getPassWord());
    }

    public void initView(){
        login = (Button) findViewById(R.id.btn_loginApp);
        noLogin = (Button) findViewById(R.id.btn_noLogin);
        toRegister = (Button) findViewById(R.id.btn_gotoRegister);
        forget = (Button) findViewById(R.id.btn_forget);

        login.setOnClickListener(this);
        noLogin.setOnClickListener(this);
        toRegister.setOnClickListener(this);
        forget.setOnClickListener(this);

        username = (EditText) findViewById(R.id.edt_username);
        password = (EditText) findViewById(R.id.edt_password);
        tv_loginFailed = (TextView) findViewById(R.id.tv_networkInfo);
        tv_loginFailed.setVisibility(View.GONE);
    }



    //不同的activity有不同的实现
    @Override
    public void onHandleMsg(int MsgType) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_loginApp:
                List<MsgObject> list = new ArrayList<>();
                mAPP.setUserName(username.getText().toString());
                mAPP.setPassWord(password.getText().toString());
                connectMsg.setType(StaticClass.MSG_LOGININF);
                DBHelper db = new DBHelper(this);
                list = db.findData(connectMsg.getType());
                for (int i = 0;i<list.size();i++){
                    if (((ConnectMsg)list.get(i)).getUsername().equals(mAPP.getUserName())
                            &&((ConnectMsg)list.get(i)).getPassword().equals(mAPP.getPassWord())){
                        intent.setClass(this,MainActivity.class);
                        startActivity(intent);
                        db.close();
                        finish();
                        return;
                    }
                }
                tv_loginFailed.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_noLogin:
                break;
            case R.id.btn_gotoRegister:
                intent.setClass(this,RegisterActivity.class);
                startActivity(intent);
                finish();
            case R.id.btn_forget:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv_loginFailed.setVisibility(View.GONE);
    }
}
