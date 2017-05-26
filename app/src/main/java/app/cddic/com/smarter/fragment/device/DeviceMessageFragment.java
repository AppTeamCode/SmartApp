package app.cddic.com.smarter.fragment.device;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.fragment.base.BaseFragment;
import app.cddic.com.smarter.fragment.base.DeviceFragment;
import app.cddic.com.smarter.utils.CommonViewHolder;
import app.cddic.com.smarter.widget.TopView;

/**
 * Created by Hai on 2017/4/26.
 */

public class DeviceMessageFragment extends BaseFragment {

    private static final String KEY_DEVICE_NAME = "deviceName";

    private String mDeviceName;

    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    private Button SendMessageBtn;

    public static DeviceMessageFragment newInstance(String deviceName) {
        DeviceMessageFragment deviceMessageFragment = new DeviceMessageFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_DEVICE_NAME, deviceName);
        deviceMessageFragment.setArguments(args);
        return deviceMessageFragment;
    }

    @Override
    protected void initViews() {

        mDeviceName = getArguments().getString(KEY_DEVICE_NAME);

        mTopView = CommonViewHolder.get(mView, R.id.device_message_topView);
        mTopView.setText("返回", mDeviceName, null);
        SendMessageBtn = CommonViewHolder.get(mView, R.id.send_message_btn);

    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        fm = getActivity().getSupportFragmentManager();

        SendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_device_message;
    }
}
