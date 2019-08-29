package com.example.hw9;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.*;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.os.*;
import android.widget.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Fragment4 extends Fragment {

    private  SimilarPro jsonObj;
   // private  SimilarPro jsonObj_name;
  //  private  SimilarPro jsonObj_day;
 //   private  SimilarPro jsonObj_price;
    private  List<Item2> jsonObj1;
    private  List<Item2>jsonObj_name;
    private  List<Item2> jsonObj_day;
    private  List<Item2> jsonObj_price;
    private  List<Item2> now;
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;
    private  View view;
    private Spinner norder;
    private Spinner aorder;
    private TextView nosimilar;
    private LinearLayout sss;
    public Fragment4 (SimilarPro jsonObj){
        this.jsonObj= jsonObj;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
         view=inflater.inflate(R.layout.layout4, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.ry1);
        sss = (LinearLayout) view.findViewById(R.id.sss);
        nosimilar =(TextView) view.findViewById(R.id.nosimilar);
        mRecyclerView.setVisibility(View.VISIBLE);
        sss.setVisibility(View.VISIBLE);
        nosimilar.setVisibility(View.GONE);

         if (jsonObj.getGetSimilarItemsResponse().getAck().equals("Success") && jsonObj.getGetSimilarItemsResponse().getItemRecommendations()!=null && jsonObj.getGetSimilarItemsResponse().getItemRecommendations().getItem().size()!=0) {
             orderJson();
             norder = (Spinner) view.findViewById(R.id.n);
             aorder = (Spinner) view.findViewById(R.id.a);
             aorder.setEnabled(false);
             initData(jsonObj1);
             now = jsonObj1;
             initView();
             norder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     //ca = getResources().getStringArray(R.array.spingarr)[position];
                     if (position == 0) {
                         aorder.setEnabled(false);
                         //   initData(jsonObj1);
                         now = jsonObj1;
                     } else {
                         aorder.setEnabled(true);
                     }
                     if (position == 1) {
                         //    initData(jsonObj_name);
                         now = jsonObj_name;
                     }
                     if (position == 2) {
                         //   initData(jsonObj_price);
                         now = jsonObj_price;
                     }
                     if (position == 3) {
                         //    initData(jsonObj_day);
                         now = jsonObj_day;
                     }
                     int k = aorder.getSelectedItemPosition();
                     if (k == 1)

                         Collections.reverse(now);

                     initData(now);
                     initView();
                 }

                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {

                 }
             });
             aorder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     //ca = getResources().getStringArray(R.array.spingarr)[position];
                     Collections.reverse(now);
                     initData(now);
                     initView();
                 }

                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {

                 }
             });
         }
         else
         {
             mRecyclerView.setVisibility(View.GONE);
             sss.setVisibility(View.GONE);
             nosimilar.setVisibility(View.VISIBLE);
         }
        return view;
    }

    private void initData(final List<Item2> jsonObj) {
        mLayoutManager = new GridLayoutManager(this.getContext(), 1, OrientationHelper.VERTICAL, false);
        mAdapter = new MyAdapter1(getData(jsonObj));
       ((MyAdapter1) mAdapter).setOnItemClickListener(new MyAdapter1.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                String url =jsonObj.get(position).getViewItemURL();

              //  System.out.println(url);
                Uri uri = Uri.parse(url);    //设置跳转的网站
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
               // Toast.makeText(ProductActivity.this,"long click " + position + " item", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public List<Map<String,Object>> getData(List<Item2> jsonObj){

        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();

        List<Item2> items = jsonObj;
        // Map<String,Object> map=new HashMap<String, Object>();
        for (int i =0; i<items.size();i++) {
            Map<String,Object> map=new HashMap<String, Object>();

            Item2 item = items.get(i);
            if (item.getImageURL()!=null){
                //   photo.add(item.getGalleryURL().get(0));
                map.put("photo",item.getImageURL());

            }
            else{

                // photo.add("N/A");
                map.put("photo","N/A");
            }
            if (item.getTitle()!=null){
                // title.add(item.getTitle().get(0));
                map.put("title",item.getTitle());
            }
            else{

                // title.add("N/A");
                map.put("title","N/A");
            }



            if (item.getShippingCost()!=null){

                if ( "0.00".equals(item.getShippingCost().get__value__())){
                    //   ship.add(sh.getShippingType().get(0));
                    map.put("ship","Free Shipping");
                    //   map.put("cost",sh.getShippingServiceCost().get(0).get__value__());
                }
                else{
                    //  ship.add(sh.getShippingServiceCost().get(0).get__value__());
                    map.put("ship","$"+item.getShippingCost().get__value__());
                }
            }
            else{

                //  ship.add("N/A");
                map.put("ship","N/A");
            }


            if (item.getTimeLeft()!=null){
                // con.add(item.getCondition().get(0).getConditionDisplayName().get(0));
               String left= item.getTimeLeft().split("P")[1].split("D")[0];
                map.put("dayleft",left+" Days Left");
            }
            else{

                map.put("dayleft","N/A");
            }

            if (item.getBuyItNowPrice()!=null){
                // price.add(item.getSellingStatus().get(0).getCurrentPrice().get(0).get__value__());
                map.put("price","$"+item.getBuyItNowPrice().get__value__());
            }
            else{

                // price.add("N/A");
                map.put("price","N/A");
            }


            list.add(map);

        }

        ///ArrayList<String> data = new ArrayList<>();
       /* String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }
*/

        return list;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.ry1);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new MyDividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new MDGridRvDividerDecoration(this.getContext()));
    }

    public void orderJson(){
        List<Item2>  items = jsonObj.getGetSimilarItemsResponse().getItemRecommendations().getItem();
        jsonObj1 = new ArrayList<Item2>();
        jsonObj_day = new ArrayList<Item2>();
        jsonObj_name = new ArrayList<Item2>();
        jsonObj_price = new ArrayList<Item2>();
        for (int i=0;i<items.size();i++) {
           jsonObj1.add(items.get(i));
            jsonObj_price.add(items.get(i));
            jsonObj_name.add(items.get(i));
            jsonObj_day.add(items.get(i));
        }
        jsonObj_name.sort(new Comparator<Item2>() {
            @Override
            public int compare(Item2 o1, Item2 o2) {
                if (o1.getTitle().compareTo(o2.getTitle()) < 0)
                    return -1;
                else if (o1.getTitle().compareTo(o2.getTitle()) > 0)

                    return 1;

                return 0;
            }
        });
        jsonObj_price.sort(new Comparator<Item2>() {
            @Override
            public int compare(Item2 o1, Item2 o2) {
                if (Double.valueOf(o1.getBuyItNowPrice().get__value__())<Double.valueOf(o2.getBuyItNowPrice().get__value__()))
                    return -1;
                else if (Double.valueOf(o1.getBuyItNowPrice().get__value__())>Double.valueOf(o2.getBuyItNowPrice().get__value__()))

                    return 1;

                return 0;
            }
        });

        jsonObj_day.sort(new Comparator<Item2>() {
            @Override
            public int compare(Item2 o1, Item2 o2) {
                int left1= (int)Integer.parseInt(o1.getTimeLeft().split("P")[1].split("D")[0]);
                int left2= (int)Integer.parseInt(o2.getTimeLeft().split("P")[1].split("D")[0]);
                if (left1<left2)
                    return -1;
                else if (left1>left2)

                    return 1;

                return 0;
            }
        });



    }

}
