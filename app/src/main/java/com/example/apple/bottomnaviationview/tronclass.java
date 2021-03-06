package com.example.apple.bottomnaviationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class tronclass  extends Fragment {
    private ListView lv;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        lv = (ListView) view.findViewById(R.id.tab_listview);    //实例化
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new SimpleAdapter(getActivity(), getData(), R.layout.tab_listview_item,
                new String[]{"img", "title", "body"},
                new int[]{R.id.itemimg, R.id.itemtitle, R.id.itembody});      //配置适配器，并获取对应Item中的ID
        lv.setAdapter(adapter);
    }
    //数据的获取@！
    private List<? extends Map<String, ?>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

//将需要的值传入map中
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "公告發布");
        map.put("body", "[會計學] 期中考解答上傳");
        map.put("img", R.drawable.ic_volume_black_24dp);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "公告發布");
        map.put("body", "[經濟學]，課堂測驗已開始");
        map.put("img", R.drawable.ic_volume_black_24dp);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "公告發布");
        map.put("body", "[資料結構]，上課教材已上傳");
        map.put("img", R.drawable.ic_volume_black_24dp);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "公告發布");
        map.put("body", "[創新創意專題]，停課通知");
        map.put("img", R.drawable.ic_volume_black_24dp);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "公告發布");
        map.put("body", "[統計學]，第二次小考公告");
        map.put("img", R.drawable.ic_volume_black_24dp);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "公告發布");
        map.put("body", "[資料結構]，小考公告");
        map.put("img", R.drawable.ic_volume_black_24dp);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "公告發布");
        map.put("body", "[統計學]  第三次小考公告");
        map.put("img", R.drawable.ic_volume_black_24dp);
        list.add(map);
        return list;
    }

}
