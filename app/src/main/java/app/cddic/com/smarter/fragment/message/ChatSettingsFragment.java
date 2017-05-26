package app.cddic.com.smarter.fragment.message;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import app.cddic.com.smarter.R;
import app.cddic.com.smarter.activity.base.ChatActivity;
import app.cddic.com.smarter.fragment.base.BaseFragment;
import app.cddic.com.smarter.utils.CommonViewHolder;
import app.cddic.com.smarter.widget.TopView;

/**
 * Created by Hai on 2017/4/25.
 */

public class ChatSettingsFragment extends BaseFragment {

    private static final String KEY_CONTACT_NAME = "contactName";

    private String mContactName;

    private TopView mTopView;
    private TextView ChatLogTv,ChatFileTv,ClearChatInformationTv;
    private TextView mContactNameTv;
    private Button DeleteContactBtn;

    public static ChatSettingsFragment newInstance(String contactName) {
        ChatSettingsFragment chatSettingsFragment = new ChatSettingsFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_CONTACT_NAME, contactName);
        chatSettingsFragment.setArguments(args);
        return chatSettingsFragment;
    }

    @Override
    protected void initViews() {

        mContactName = getArguments().getString(KEY_CONTACT_NAME);

        mTopView =  CommonViewHolder.get(mView,R.id.chat_setting_topView);
        mTopView.setText("返回","聊天设置",null);
        mContactNameTv = findView(R.id.contactName_tv);
        mContactNameTv.setText(mContactName);
        ChatLogTv = CommonViewHolder.get(mView, R.id.chat_log_tv);
        ChatFileTv =  CommonViewHolder.get(mView,R.id.chat_file_tv);
        ClearChatInformationTv = CommonViewHolder.get(mView,R.id.clear_information_tv);
        DeleteContactBtn = CommonViewHolder.get(mView,R.id.delete_contact_btn);
    }

    @Override
    protected void setupAdapters() {

    }

    @Override
    protected void setupListeners() {

        mTopView.setupListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ((ChatActivity)mActivity).replaceCurrentFragment(
                        ChatFragment.newInstance(mContactName)
                );
            }
        }, null);

        ChatLogTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ChatFileTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ClearChatInformationTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        DeleteContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_chat_settings;
    }
}
