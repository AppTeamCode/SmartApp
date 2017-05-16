package app.cddic.com.smarter.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.entity.RegisterMSG;
import app.cddic.com.smarter.fragment.ACNumberFragment;
import app.cddic.com.smarter.fragment.BaseFragment;
import app.cddic.com.smarter.fragment.CheckPhoneFragment;
import app.cddic.com.smarter.fragment.InforFragment;
import app.cddic.com.smarter.fragment.ResultFragment;

/**
 * 项目名：  SmartApp
 * 包名：    app.cddic.com.smarter.activity.base
 * 文件名：  RegisterActivity
 * 创建者：
 * 创建时间： 2017/4/11 16:08
 * 描述：
 */

public class RegisterActivity extends BaseActivity {
    private RegisterMSG registerMsg;
    private List<BaseFragment> list;

    private CheckPhoneFragment fragment1;
    private InforFragment fragment2;
    private ACNumberFragment fragment3;
    private ResultFragment fragment4;

    public void setRegisterMsg(RegisterMSG registerMsg) {
        this.registerMsg = registerMsg;
    }

    public RegisterMSG getRegisterMsg(){
        return registerMsg;
    }

    public List<BaseFragment> getList() {
        return list;
    }

    public void setList(List<BaseFragment> list) {
        this.list = list;
    }


    @Override
    public void onHandleMsg(int MsgType) {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initData();
        mFragmentManager.beginTransaction().add(R.id.container,fragment1,null).commit();

    }

    private void initData() {
        registerMsg = new RegisterMSG();
        list = new ArrayList<>();
        fragment1 = new CheckPhoneFragment();
        fragment2 = new InforFragment();
        fragment3 = new ACNumberFragment();
        fragment4 = new ResultFragment();

        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
    }


}
