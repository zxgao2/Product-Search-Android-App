package com.example.hw9;
import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.support.v4.content.*;
import android.support.v4.graphics.drawable.*;
import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.wssholmes.stark.circular_score.*;
import android.text.*;
import android.text.method.*;
import android.text.style.*;
import android.content.DialogInterface.*;
import android.graphics.drawable.*;
import android.app.ActionBar.*;
import java.util.*;
public class Fragment3 extends Fragment {
    private View view;
    private GooglePhoto jsonObj;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> data_list;
    private GridView mGridView;
    private mGridViewAdapter adapter;

    public Fragment3(GooglePhoto jsonObj) {
        this.jsonObj = jsonObj;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view=inflater.inflate(R.layout.layout3, container, false);
        TextView no = (TextView) view.findViewById(R.id.nor);
        GridView tl =(GridView) view.findViewById(R.id.mGridView);
        no.setVisibility(View.GONE);
        tl.setVisibility(View.VISIBLE);
        if (jsonObj.getItems()!=null){
        generatePhoto();
        }
        else
        {
            no.setVisibility(View.VISIBLE);
            tl.setVisibility(View.GONE);
        }

        return view;
    }
    public void generatePhoto(){
        mGridView = (GridView) view.findViewById(R.id.mGridView);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < jsonObj.getItems().size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", jsonObj.getItems().get(i).getLink());
            list.add(map);
        }

        data_list=list;
        adapter = new mGridViewAdapter(this.getContext(), data_list);
       // adapter.setSelection(0);
        mGridView.setAdapter(adapter);


    }

}
