package app.cddic.com.smarter.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.entity.ConnectMsg;
import app.cddic.com.smarter.entity.MsgObject;
import app.cddic.com.smarter.entity.RetMsg;
import app.cddic.com.smarter.utils.StaticClass;

public class TestActivity extends BaseActivity{

    RetMsg ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //如果是通知栏启动，接收通知栏信息
        Intent intent = this.getIntent();
        int msgType = intent.getIntExtra("MsgType",0);
        if(msgType !=0 ) {
            Toast.makeText(getApplicationContext(), "通知栏启动界面",  Toast.LENGTH_SHORT).show();
            onHandleMsg(msgType);
        }

        Button breg = (Button) findViewById(R.id.login_plat);
        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录平台处理
                EditText pass = (EditText)findViewById(R.id.input_pass);
                EditText user = (EditText)findViewById(R.id.input_user);
                String pWord = pass.getText().toString();
                String pUser = user.getText().toString();
                if(!(pWord.length() > 0 && pUser.length()>0)) {
                    TextView show = (TextView) findViewById(R.id.show_devinf);
                    show.setText("输入信息不完整，请重新输入！");
                }else {
                    if(mAPP.getLoginState() == 0) {
                        ConnectMsg loginMsg = new ConnectMsg();
                        loginMsg.setPassword(pWord);
                        loginMsg.setUsername(pUser);
                        loginMsg.setSnum("test");
                        loginMsg.setSver("010101");
                        loginMsg.setPort(0);
                        loginMsg.setType(StaticClass.MSG_LOGIN);
                        setMsg(loginMsg); //将消息发送给服务执行
                    }
                }
            }
        });

        Button bFind = (Button) findViewById(R.id.lan_find);
        bFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //局域网发现处理
                EditText user = (EditText)findViewById(R.id.input_user);
                String pUser = user.getText().toString();
                if(!( pUser.length()>0)) {
                    TextView show = (TextView) findViewById(R.id.show_devinf);
                    show.setText("必须输入用户名！");
                }else {
                    ConnectMsg findMsg = new ConnectMsg();
                    findMsg.setUsername(pUser);
                    findMsg.setType(StaticClass.MSG_LANFIND);
                    setMsg(findMsg); //将消息发送给服务执行
                }
            }
        });

        Button bn = (Button) findViewById(R.id.login_dev);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录设备处理
                EditText pass = (EditText)findViewById(R.id.input_pass);
                EditText user = (EditText)findViewById(R.id.input_user);
                String pWord = pass.getText().toString();
                String pUser = user.getText().toString();
                if(!(pWord.length() > 0 && pUser.length()>0)) {
                    TextView show = (TextView) findViewById(R.id.show_devinf);
                    show.setText("输入信息不完整，请重新输入！");
                }else {
                    if(mAPP.getLoginDevState() == 0) {
                        ConnectMsg devMsg = new ConnectMsg();
                        devMsg.setPassword(pWord);
                        devMsg.setUsername(pUser);
                        devMsg.setSnum("test");
                        devMsg.setSver("010101");
                        devMsg.setPort(5678);   //本部分信息应该通过id查询得到
                        devMsg.setAddress("127.0.0.1");
                        devMsg.setType(StaticClass.MSG_LOGIN);
                        setMsg(devMsg); //将消息发送给服务执行
                    }
                }
            }
        });

        Button bExit = (Button) findViewById(R.id.app_exit);
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出应用程序
                MsgObject exitMsg = new MsgObject();
                exitMsg.setType(StaticClass.MSG_EXIT);
                setMsg(exitMsg);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }

    //封装从service接收信息, 由HandleMsg调用；
    // @Override
    public void onHandleMsg(int MSGType) {
        Log.i("Test","get a msg"+MSGType);
        TextView show = (TextView) findViewById(R.id.show_devinf);
        ret=(RetMsg)getMsg(MSGType);

        if(MSGType != ret.getType()) {
            show.setText("消息已经过时！！！！");
            return;
        }
        switch (MSGType){
            case StaticClass.MSG_LOGIN:
                if(ret.getSort()==3) {
                    if (ret.getState() >= 0)
                        show.setText("登录平台成功！");
                    else
                        show.setText("登录平台失败，用户名或者密码可能错误");
                }else {
                    if(ret.getState() >=0)
                        show.setText("登录设备成功！");
                    else
                        show.setText("登录设备失败，请检查用户名或者密码");
                }
                break;
            case StaticClass.MSG_LANFIND:
                show.setText("发现前端设备："+ret.getFromIP()+ret.getPort());
                break;
            default:
                show.setText("不支持的消息编号");
                break;
        }
    }
}
