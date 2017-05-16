package app.cddic.com.smarter.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.cddic.com.smarter.R;

/**
 * Created by Hai on 2017/5/10.
 */

public class DeviceDetailsGridView extends Activity {
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.drawing_board, R.drawable.drawing_board, R.drawable.drawing_board,
            R.drawable.drawing_board, R.drawable.drawing_board, R.drawable.drawing_board};
    private String[] iconName = { "设置", "分享", "管理", "控制", "消息", "视频"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_details_test);
        gview = (GridView) findViewById(R.id.gview);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.activity_device_details_item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }



    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }
}