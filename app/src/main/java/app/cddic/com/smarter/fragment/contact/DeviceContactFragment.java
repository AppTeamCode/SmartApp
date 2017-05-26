package app.cddic.com.smarter.fragment.contact;

/**
 * Created by 小帆哥 on 2017/5/9.
 */

import android.view.View;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.fragment.base.BaseFragment;
import app.cddic.com.smarter.widget.TopView;


public class DeviceContactFragment extends BaseFragment {

    private TopView mTopView;

    protected void initViews() {

        mTopView =findView(R.id.quick_processing_topView);
        mTopView.setText("联系人","设备关联人",null);
    }
    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        mTopView.setupListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        },null);

    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_device_contact;
    }
}

