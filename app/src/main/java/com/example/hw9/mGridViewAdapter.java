package com.example.hw9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;


import java.util.List;
import java.util.Map;
import android.view.ViewGroup.*;

public class mGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> listItem;
    private int clickItem = -1;


    public mGridViewAdapter(Context context, List<Map<String, Object>> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    public void setSelection(int position) {
        this.clickItem = position;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
       // TextView textView = (TextView) convertView.findViewById(R.id.text);

        Map<String, Object> map = listItem.get(position);
        Glide.with(imageView.getContext()).load(map.get("ItemImage").toString()).into(imageView);
        imageView.setAdjustViewBounds(true);
       /* imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));*/
       // imageView.setImageResource((Integer) map.get("ItemImage"));
      //  textView.setText(map.get("ItemText") + "");


        return convertView;
    }
}
