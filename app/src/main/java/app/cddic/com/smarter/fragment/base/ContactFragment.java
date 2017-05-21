package app.cddic.com.smarter.fragment.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import app.cddic.com.smarter.R;
import app.cddic.com.smarter.activity.base.ContactActivity;
import app.cddic.com.smarter.adapter.ContactItemsAdapter;


/**
 * Created by Pantiy on 2017/3/12.
 * Copyright © 2016 All rights Reserved by Pantiy
 */

public class ContactFragment extends BaseFragment {

    private LinearLayout mNewFriends;
    private LinearLayout mDeviceContact;
    private ExpandableListView mContactElv;

    @Override
        protected void initViews() {
        mContactElv = findView(R.id.contact_elv);
        mNewFriends = findView(R.id.newFriends);
        mDeviceContact = findView(R.id.deviceContact);
    }

    @Override
    protected void setupAdapters() {
        ContactItemsAdapter adapter = new ContactItemsAdapter(getActivity());
        mContactElv.setAdapter(adapter);
    }

    @Override
    protected void setupListeners() {

        mNewFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContactActivity(ContactActivity.Type.NEW_FRIENDS);
            }
        });

        mDeviceContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startContactActivity(ContactActivity.Type.DEVICE_CONTACT);
            }
        });

        mContactElv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String contactName = (String ) parent.getExpandableListAdapter()
                        .getChild(groupPosition, childPosition);
                startContactActivity(ContactActivity.Type.CONTACT_DETAIL, contactName);
                return true;
            }
        });

        mContactElv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final long packedPosition = mContactElv.getExpandableListPosition(position);
                final int groupPosition = ExpandableListView.getPackedPositionGroup(packedPosition);
                final int childPosition = ExpandableListView.getPackedPositionChild(packedPosition);
                if (childPosition != -1) {
                    new AlertDialog.Builder(getActivity())
                            .setItems(new String[]{"关联", "删除"},
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    })
                            .show();
                }
                return true;
            }
        });
    }

    private void startContactActivity(int type) {
        Intent intent = ContactActivity.newInstance(getActivity(), type);
        startActivity(intent);
    }

    private void startContactActivity(int type, String contactName) {
        Intent intent = ContactActivity.newInstance(getActivity(), type, contactName);
        startActivity(intent);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.fragment_contact;
    }
}
