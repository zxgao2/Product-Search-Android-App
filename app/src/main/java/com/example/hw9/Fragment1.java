package com.example.hw9;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.*;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import android.widget.LinearLayout.LayoutParams;

import java.util.*;
public class Fragment1 extends Fragment {
    private LinearLayout mGallery;
    private List<String> mImgIds = new ArrayList<String>();
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;
    private View view;
    private detailPro jsonObj;
    private String shippingcost;


    public  Fragment1(){ }

    public  Fragment1(detailPro jsonObj,String shippingcost) {  this.jsonObj = jsonObj; this.shippingcost=shippingcost;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view= inflater.inflate(R.layout.layout1, container, false);
       // container.addView();
       // mInflater = LayoutInflater.from(.getContext());
        initData();
        initView();
        TextView title = (TextView) view.findViewById(R.id.protitle);
        title.setText(jsonObj.getItem().getTitle());
        TextView cost = (TextView) view.findViewById(R.id.cost);
        String ss;
        if ("0.0".equals(shippingcost)) {
            ss="$" + jsonObj.getItem().getCurrentPrice().getValue() +" With Free Shipping" ;
        }
        else{
            ss="$" + jsonObj.getItem().getCurrentPrice().getValue() +" With $"+ shippingcost+ " Shipping";
        }
        //对View中控件的操作方法
        SpannableString spannableString = new SpannableString(ss);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#673AB7")), 0, jsonObj.getItem().getCurrentPrice().getValue().length()+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        cost.setText(spannableString);
        TableLayout high = (TableLayout) view.findViewById(R.id.highlight);
        if (jsonObj.getItem().getSubtitle()!=null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Subtitle");


            text.setGravity(Gravity.LEFT); //居中显示
            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setWidth(100);
            row.addView(text_b);
            TextView text1 = new TextView(this.getContext());

            //设置显示内容
            text1.setText(jsonObj.getItem().getSubtitle());


            text1.setGravity(Gravity.LEFT); //居中显示
            text1.setSingleLine(false);
            text1.setLines(2);
            text1.setMaxLines(2);
            text1.setMinLines(2);
            text1.setWidth(650);



            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }
        if (jsonObj.getItem().getCurrentPrice().getValue()!=null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Price");
            text.setGravity(Gravity.LEFT);


            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setWidth(100);
            row.addView(text_b);
            TextView text1 = new TextView(this.getContext());

            //设置显示内容
            text1.setText("$"+jsonObj.getItem().getCurrentPrice().getValue());


            text1.setGravity(Gravity.LEFT); //居中显示
            text1.setSingleLine(false);



            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }


        if (jsonObj.getItem().getBrand()!=null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Brand");
            text.setGravity(Gravity.LEFT);
 //居中显示
            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setWidth(100);
            row.addView(text_b);
            TextView text1 = new TextView(this.getContext());

            //设置显示内容
            text1.setText(jsonObj.getItem().getBrand());


            text1.setGravity(Gravity.LEFT); //居中显示
            text1.setSingleLine(false);


            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }

        TextView spe = (TextView) view.findViewById(R.id.spe);
        if ( jsonObj.getItem().getItemSpecifics()!=null && jsonObj.getItem().getItemSpecifics().getNameValueList()!=null) {
            List<NameValueList> its = jsonObj.getItem().getItemSpecifics().getNameValueList();
            int k = 0;
            for (int j=0; j<its.size();j++)
            {
                if ("Brand".equals(its.get(j).getName())){
                    k=j;
                    System.out.println(k);
                }

            }
            NameValueList s = its.get(k);
            its.set(k,its.get(0));
            its.set(0,s);
            System.out.println(its.get(0).getName());

            for (int j=0; j<its.size();j++)
            {
                String name = jsonObj.getItem().getItemSpecifics().getNameValueList().get(j).getValue().get(0);

                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                TextView text_b = new TextView(this.getContext());
                text_b.setText(name);

                Drawable drawable= getResources().getDrawable(R.drawable.circlem);
///
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                text_b.setCompoundDrawables(drawable,null,null,null);

                 LinearLayout sss=(LinearLayout) view.findViewById(R.id.ss);
               //  text_b.setDraw

                 sss.addView(text_b);



            }
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(100);
            text_b.setVisibility(View.INVISIBLE);
            LinearLayout sss=(LinearLayout) view.findViewById(R.id.ss);

            sss.addView(text_b);
        }
        else{
            spe.setVisibility(View.GONE);
        }


        return view;
    }
    private void initData()
    {
        mImgIds=jsonObj.getItem().getPictureURL();
    }

    private void initView()
    {
        mGallery = (LinearLayout) view.findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.size(); i++)
        {

            View view1 = LayoutInflater.from(mGallery.getContext()).inflate(R.layout.activity_gallery_item,mGallery,
                     false);
            ImageView img = (ImageView) view1
                    .findViewById(R.id.id_index_gallery_item_image);
           //Glide.
           // img.setImageResource(mImgIds[i]);
            Glide.with(img.getContext()).load(mImgIds.get(i)).into(img);

            mGallery.addView(view1);
        }
    }


}

