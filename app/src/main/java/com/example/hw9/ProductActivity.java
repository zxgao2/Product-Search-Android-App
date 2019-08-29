package com.example.hw9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.sip.SipAudioCall;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.android.volley.Request.*;
import com.google.gson.Gson;

import android.text.Html;
import android.view.*;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.util.*;
import java.util.*;
import java.lang.*;
//import java.lang.String;
import android.content.*;
import java.io.*;
import android.support.v7.widget.*;
import android.text.*;
import android.text.style.*;
import android.graphics.*;
import android.support.v7.widget.helper.*;



public class ProductActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar pb;
    private TextView pt;
    private TextView showing;
    private List<String> shippingcost = new ArrayList<>();
    private TextView nore;

  //  private ImageView back = (ImageView) findViewById(R.id.backPro);
    interface Listener {
        void response(String string);
    }
    RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getSupportActionBar().hide();//隐藏标题栏
        nore = (TextView) findViewById(R.id.noresult);
        pb =(ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.VISIBLE);
        pt = (TextView) findViewById(R.id.progresstext);
        pt.setVisibility(View.VISIBLE);
        showing = (TextView) findViewById(R.id.showing);
        showing.setVisibility(View.INVISIBLE);
        nore.setVisibility(View.GONE);
        mQueue = Volley.newRequestQueue(ProductActivity.this);
        getproduct();




    }
    public void backForm(View source){
     //   Intent intent = new Intent();
        /* 指定intent要启动的类 */
       // intent.setClass(ProductActivity.this, MainActivity.class);
     //   startActivity(intent);
        /* 关闭当前的Activity */
        ProductActivity.this.finish();
    }

    private void initData(final JsonRootBean jsonObj) {
        mLayoutManager = new GridLayoutManager(this, 2, OrientationHelper.VERTICAL, false);
        mAdapter = new MyAdapter(getData(jsonObj));
        ((MyAdapter) mAdapter).setOnItemClickListener(new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
             //   Toast.makeText(ProductActivity.this,"click " + position + " item", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                /* 指定intent要启动的类 */
                intent.setClass(ProductActivity.this, Detail.class);
                intent.putExtra("ItemID",jsonObj.getFindItemsAdvancedResponse().get(0).getSearchResult().get(0).getItem().get(position).getItemId().get(0));
              //  intent.putExtra("smalltitle",keyword.getText().toString());
                intent.putExtra("shippingcost",shippingcost.get(position));
                intent.putExtra("title",jsonObj.getFindItemsAdvancedResponse().get(0).getSearchResult().get(0).getItem().get(position).getTitle().get(0));

                /* 启动一个新的Activity */
                startActivity(intent);
                /* 关闭当前的Activity */
               // ProductActivity.this.finish();
               // ConstraintLayout cs = (ConstraintLayout) findViewById(R.id.prore);
              //  cs.setVisibility(View.GONE);
            }

            @Override
            public void onItemLongClick(View view, int position) {
             //   Toast.makeText(ProductActivity.this,"long click " + position + " item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.ry);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new MDGridRvDividerDecoration(this));
    }

    private List<Map<String,Object>> getData(JsonRootBean jsonObj) {
         List<String> photo= new ArrayList<String>();
         List<String> title= new ArrayList<String>();;
         List<String> zip= new ArrayList<String>();;
         List<String> ship= new ArrayList<String>();;
         List<String> con= new ArrayList<String>();;
         List<String> price= new ArrayList<String>();;
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();

        List<Item> items = jsonObj.getFindItemsAdvancedResponse().get(0).getSearchResult().get(0).getItem();
       // Map<String,Object> map=new HashMap<String, Object>();
        for (int i =0; i<items.size();i++) {
            Map<String,Object> map=new HashMap<String, Object>();

            Item item = items.get(i);
            if (item.getGalleryURL()!=null){
             //   photo.add(item.getGalleryURL().get(0));
                map.put("photo",item.getGalleryURL().get(0));

        }
            else{

               // photo.add("N/A");
                map.put("photo","N/A");
            }
            if (item.getTitle()!=null){
               // title.add(item.getTitle().get(0));
                map.put("title",item.getTitle().get(0));
            }
            else{

               // title.add("N/A");
                map.put("title","N/A");
            }

            if (item.getPostalCode()!=null){
              //  zip.add(item.getPostalCode().get(0));
                map.put("zip","Zip: "+item.getPostalCode().get(0));

            }
            else{

                //zip.add("N/A");
                map.put("zip","N/A");
            }

            if (item.getShippingInfo()!=null){
                ShippingInfo sh =item.getShippingInfo().get(0);
                if (sh.getShippingServiceCost()==null || "0.0".equals(sh.getShippingServiceCost().get(0).get__value__())){
                 //   ship.add(sh.getShippingType().get(0));
                    map.put("ship",sh.getShippingType().get(0));
                 //   map.put("cost",sh.getShippingServiceCost().get(0).get__value__());
                }
                else{
                  //  ship.add(sh.getShippingServiceCost().get(0).get__value__());
                    map.put("ship","$"+sh.getShippingServiceCost().get(0).get__value__());
                }
            }
            else{

              //  ship.add("N/A");
            map.put("ship","N/A");
            }


            if (item.getCondition()!=null){
               // con.add(item.getCondition().get(0).getConditionDisplayName().get(0));
                map.put("condition",item.getCondition().get(0).getConditionDisplayName().get(0));
            }
            else{

                map.put("condition","N/A");
            }

            if (item.getSellingStatus()!=null){
               // price.add(item.getSellingStatus().get(0).getCurrentPrice().get(0).get__value__());
                map.put("price","$"+item.getSellingStatus().get(0).getCurrentPrice().get(0).get__value__());
            }
            else{

               // price.add("N/A");
                map.put("price","N/A");
            }

               /* map.put("photo",photo);
                map.put("title",title);
                map.put("zip",zip);
                map.put("ship",ship);
                map.put("condition",con);
                map.put("price",price);*/
                list.add(map);
                if (item.getShippingInfo()!=null && item.getShippingInfo().get(0).getShippingServiceCost()!=null)
                shippingcost.add(item.getShippingInfo().get(0).getShippingServiceCost().get(0).get__value__());
                else{
                    shippingcost.add("N/A");
                }
        }

       ///ArrayList<String> data = new ArrayList<>();
       /* String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }
*/

        return list;
    }
    private void getproduct(){
        final Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        System.out.println("http://127.0.0.1:8080/ebayproduct?"+data);
        addRequest("https://vocal-clone-237107.appspot.com/ebayproduct?"+data, new Listener() {
            @Override
            public void response(String response) {
                //textView.setText(response);
                pb =(ProgressBar) findViewById(R.id.progressBar);
                pb.setVisibility(View.INVISIBLE);
                pt = (TextView) findViewById(R.id.progresstext);
                pt.setVisibility(View.INVISIBLE);
                showing.setVisibility(View.VISIBLE);
                System.out.println((response));
                System.out.println(response.trim().substring(1,response.length()-1));
              //  JsonReader jsonReader = new JsonReader(new StringReader(response));//其中jsonContext为String类型的Json数据
             //   jsonReader.setLenient(true);


                Gson gson=new Gson();
               // String myJson=   gson.toJson(response);
               // System.out.println(myJson);
                JsonRootBean jsonObj = gson.fromJson(response,JsonRootBean.class);
               if ("Success".equals(jsonObj.getFindItemsAdvancedResponse().get(0).getAck().get(0)) && !("0".equals(jsonObj.getFindItemsAdvancedResponse().get(0).getSearchResult().get(0).getCount()))) {
                   showing = (TextView) findViewById(R.id.showing);
                   String st = "Showing " + jsonObj.getFindItemsAdvancedResponse().get(0).getSearchResult().get(0).getCount() + " results for " + intent.getStringExtra("smalltitle");
                   SpannableString spannableString = new SpannableString(st);
                   spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF5722")), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                   spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF5722")), 22, st.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                   showing.setText(spannableString);

                   //  showing.setText(Html.fromHtml("showing <font color='#FFFF5722'>"+jsonObj.getFindItemsAdvancedResponse().get(0).getSearchResult().get(0).getCount()+"</font> results for <font color='#FFFF5722'>"+intent.getStringExtra("smalltitle"))+"</font>");

                   initData(jsonObj);
                   initView();
                   System.out.println(jsonObj.getFindItemsAdvancedResponse().get(0).getSearchResult().get(0).getCount());
               }
               else{
                   showing = (TextView) findViewById(R.id.showing);
                   String st = "Showing 0" + " results for " + intent.getStringExtra("smalltitle");
                   SpannableString spannableString = new SpannableString(st);
                   spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF5722")), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                   spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF5722")), 22, st.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                   showing.setText(spannableString);
                    nore.setVisibility(View.VISIBLE);
               }
            }
        });
    }


    private void addRequest(String url, final Listener listener) {
        final StringRequest stringRequest2 = new StringRequest(Method.GET,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    listener.response(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        mQueue.add(stringRequest2);
    }


}



