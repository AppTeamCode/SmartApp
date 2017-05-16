package app.cddic.com.smarter.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.widget.TopView;

/**
 * Created by Hai on 2017/5/10.
 */

public class NewContactFragment extends BaseFragment {

    private FragmentManager fm;
    private Fragment fragment;
    private TopView mTopView;
    @Override
    protected void initViews() {
        mTopView = findView(R.id.new_contact_TopView);
        mTopView.setText("联系人","新联系人",null);
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
    }

    @Override
    protected int setLayoutRes() {
        return  R.layout.fragment_new_contact;
    }
}
