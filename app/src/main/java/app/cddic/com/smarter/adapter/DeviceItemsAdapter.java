package app.cddic.com.smarter.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.activity.base.DeviceActivity;
import app.cddic.com.smarter.utils.CommonViewHolder;


/**
 * Created by Pantiy on 2017/3/13.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class DeviceItemsAdapter extends BaseAdapter {

    private Context mContext;

    public DeviceItemsAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_for_device,viewGroup,false);
        }

        LinearLayout left = CommonViewHolder.get(view, R.id.left_deviceItem);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDeviceActivity(DeviceActivity.Type.DEVICE_DETAIL, "");
            }
        });

        LinearLayout right = CommonViewHolder.get(view, R.id.right_deviceItem);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDeviceActivity(DeviceActivity.Type.DEVICE_MESSAGE, "");
            }
        });

        return view;
    }

    private void startDeviceActivity(int type, String deviceName) {
        Intent intent = DeviceActivity.newInstance(mContext, type, deviceName);
        mContext.startActivity(intent);
    }
}
