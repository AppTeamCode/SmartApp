package app.cddic.com.smarter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.activity.base.RegisterActivity;

/**
 * 项目名：  SmartApp
 * 包名：    app.cddic.com.smarter.fragment
 * 文件名：  CheckPhoneFragment
 * 创建者：
 * 创建时间： 2017/4/15 13:39
 * 描述：手机验证页面
 */

public class CheckPhoneFragment extends BaseFragment {
    private TextView next;
    private EditText phoneNum;
    InforFragment fragmeng1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_checkphone,null);
        next = (TextView) v.findViewById(R.id.tv_next);
        phoneNum = (EditText) v.findViewById(R.id.mobileNumber);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取注册消息对象并添加数据
                ((RegisterActivity)mActivity).getRegisterMsg().setPhoneNum(phoneNum.getText().toString());
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.container,fragmeng1).commit();
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //从activity获取fragment
        fragmeng1 = (InforFragment) ((RegisterActivity)mActivity).getList().get(1);
    }

    @Override
    protected void initViews() {


    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected int setLayoutRes() {
        return 0;
    }
}
