package app.cddic.com.smarter.fragment.contact;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.fragment.base.BaseFragment;
import app.cddic.com.smarter.fragment.base.DeviceFragment;
import app.cddic.com.smarter.widget.TopView;

/**
 * Created by Hai on 2017/5/10.
 */

public class NewFriendsFragment extends BaseFragment {

    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    @Override
    protected void initViews() {
        mTopView = findView(R.id.new_contact_TopView);
        mTopView.setText("返回","新朋友",null);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {
        mTopView.setupListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getActivity().finish();
            }
        },null);
    }

    @Override
    protected int setLayoutRes() {
        return  R.layout.fragment_new_contact;
    }
}
