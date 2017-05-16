package app.cddic.com.smarter.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Switch;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.widget.TopView;

/**
 * Created by Hai on 2017/5/10.
 */

public class PrivacyManagementFragment extends BaseFragment {

    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    private Switch SavePasswordSw,AddValidationSw,AssociationVerificationSw,AutomaticLogonSw,SeeAccountSw,StrNewsSw;
    @Override
    protected void initViews() {
        mTopView = findView(R.id.privacy_management_TopView);
        mTopView.setText("返回","隐私管理",null);
        SavePasswordSw = findView(R.id.save_password_switch);
        AddValidationSw = findView(R.id.add_validation_switch);
        AssociationVerificationSw = findView(R.id.association_verification_switch);
        AutomaticLogonSw = findView(R.id.automatic_logon_switch);
        SeeAccountSw = findView(R.id.see_account_switch);
        StrNewsSw = findView(R.id.strange_news_switch);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        fm = getActivity().getSupportFragmentManager();
        mTopView.setupListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fragment = new DeviceFragment();/*这个返回界面还没写，应该是聊天界面*/
                fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        },null);


        SavePasswordSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AddValidationSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AssociationVerificationSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AutomaticLogonSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        SeeAccountSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        StrNewsSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_privacy_management;
    }
}
