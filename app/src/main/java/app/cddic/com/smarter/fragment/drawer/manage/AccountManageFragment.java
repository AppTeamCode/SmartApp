package app.cddic.com.smarter.fragment.drawer.manage;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.widget.TopView;


/**
 * Created by asus on 2017/3/28.
 */

public class AccountManageFragment extends ManageFragment {

    private TopView mTopView;
    private TextView text_id_manage_add;
    private TextView textView_id_manage_login_setting;
    private TextView textView_id_manage_exit;
    private TextView textView_id_manage_test1;
    private TextView textView_account_manage_test1;
    private TextView textView_id_manage_name1;
    private TextView textView_account_manage_name1;
    private TextView mTextView_exit;
    private android.support.v4.app.FragmentManager fm;
    private Fragment fragment;
    private static final String DIALOG_DATE = "DialogDate";

    @Override
    protected void setFragmentName() {
        mFragmentName="账号管理";
    }


    @Override
    protected void initViews() {
        text_id_manage_add = (TextView) mView.findViewById(R.id.textview_id_manage_add);
        textView_id_manage_login_setting = (TextView)mView.findViewById(R.id.textview_id_manage_login_setting);
        textView_id_manage_exit = (TextView)mView.findViewById(R.id.textview_id_manage_exit);
        textView_id_manage_test1 = (TextView)mView.findViewById(R.id.textView_id_manage_test1);
        textView_account_manage_test1 = (TextView)mView.findViewById(R.id.textview_id_manage_name1);
        textView_id_manage_name1 = (TextView)mView.findViewById(R.id.textview_id_manage_name1);
        textView_account_manage_name1 = (TextView)mView.findViewById(R.id.textview_account_manage_name1);
        mTextView_exit =(TextView)mView.findViewById(R.id.textview_id_manage_exit);
        textView_id_manage_test1.setVisibility(View.VISIBLE);
        textView_account_manage_test1.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {

        fm = getActivity().getSupportFragmentManager();
        text_id_manage_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                fragment = new AddDeviceFragment();
                fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });


        textView_id_manage_login_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                fragment = new LoginSettingFragment();
                fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
        textView_id_manage_exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentManager manager = getFragmentManager();

            }
        });
        textView_id_manage_name1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_id_manage_test1.setVisibility(View.VISIBLE);
                textView_account_manage_test1.setVisibility(View.INVISIBLE);
            }
        });
        textView_account_manage_name1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_id_manage_test1.setVisibility(View.INVISIBLE);
                textView_account_manage_test1.setVisibility(View.VISIBLE);
            }
        });

        mTextView_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = null;
                ad = new AlertDialog.Builder(getActivity());
                ad.setTitle("是否确定退出当前设备");
                ad.setMessage("登录时间:7月9号12：23-10号15：23\n\n远程登录         时长:27小时");
                ad.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ad.setNegativeButton("确认退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ad.show();

            }
        });

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_account_manage;
    }
}
