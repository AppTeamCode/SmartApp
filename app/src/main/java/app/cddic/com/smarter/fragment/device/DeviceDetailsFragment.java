package app.cddic.com.smarter.fragment.device;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import app.cddic.com.smarter.R;
import app.cddic.com.smarter.fragment.base.BaseFragment;
import app.cddic.com.smarter.widget.TopView;

/**
 * Created by Hai on 2017/5/10.
 */

public class DeviceDetailsFragment extends BaseFragment {

    private GridView gridview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.drawing_board, R.drawable.drawing_board, R.drawable.drawing_board,
            R.drawable.drawing_board, R.drawable.drawing_board, R.drawable.drawing_board};
    private String[] iconName = { "设置", "分享", "管理", "控制", "消息", "视频"};


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
        gridview = findView(R.id.device_details_gridView);
        //新建List
        data_list = new ArrayList<>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(mActivity, data_list, R.layout.activity_device_details_item, from, to);
        //配置适配器
        gridview.setAdapter(sim_adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected void setupListeners() {
        fm = getActivity().getSupportFragmentManager();
        mTopView.setupListeners(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        },null);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
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


    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

}
