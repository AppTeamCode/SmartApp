package app.cddic.com.smarter.activity.base;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import app.cddic.com.smarter.fragment.device.DeviceDetailsFragment;
import app.cddic.com.smarter.fragment.device.DeviceMessageFragment;

/**
 * SmartApp
 * app.cddic.com.smarter.activity.base
 * Created by Pantiy on 2017/5/21.
 * Copyright © 2017 All rights Reserved by Pantiy
 */

public class DeviceActivity extends SingleFragmentActivity {

    private static final String EXTRA_TYPE = "extraType";
    private static final String EXTRA_DEVICE_NAME = "deviceName";

    public static Intent newInstance(Context context, int type, String deviceName) {
        Intent intent = new Intent(context, DeviceActivity.class);
        intent.putExtra(EXTRA_TYPE, type);
        intent.putExtra(EXTRA_DEVICE_NAME, deviceName);
        return intent;
    }

    @Override
    public void onHandleMsg(int MsgType) {

    }

    @Override
    protected Fragment createFragment() {

        switch (getIntent().getIntExtra(EXTRA_TYPE, -1)) {

            case Type.DEVICE_DETAIL:
                return new DeviceDetailsFragment();

            case Type.DEVICE_MESSAGE:
                return DeviceMessageFragment.newInstance(getIntent().getStringExtra(EXTRA_DEVICE_NAME));

            default:
                return null;
        }

    }

    public static final class Type {
        public static final int DEVICE_DETAIL = 0;
        public static final int DEVICE_MESSAGE = 1;
    }
}
