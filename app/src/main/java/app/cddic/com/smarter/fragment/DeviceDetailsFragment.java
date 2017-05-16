package app.cddic.com.smarter.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.widget.TopView;

/**
 * Created by Hai on 2017/5/10.
 */

public class DeviceDetailsFragment extends BaseFragment {

    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    private Button LoginBtn;
    private Spinner spinner;
    @Override
    protected void initViews() {
        mTopView = findView(R.id.device_details_TopView);
        mTopView.setText("设备","设备详情","厨房设备");
        LoginBtn = findView(R.id.login_btn);
        spinner = findView(R.id.Spinner);
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

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected int setLayoutRes()
    {
        return R.layout.fragment_device_details;
    }
}
