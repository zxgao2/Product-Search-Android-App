package com.example.hw9;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import android.net.*;
import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;
import java.util.*;
import android.support.v4.view.*;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class Detail extends AppCompatActivity {
    private ProgressBar pb;
    private TextView pt;
    private LinearLayout linebar;
    private detailPro currentpro;
    private  ViewPager vp;
    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;
    private  GooglePhoto gp;
    private SimilarPro sp;
   // private TextView showing;
   interface Listener {
       void response(String string);
   }
    RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Fresco.initialize(this);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();//隐藏标题栏
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.VISIBLE);
        pt = (TextView) findViewById(R.id.progresstext);
        pt.setVisibility(View.VISIBLE);
        linebar = (LinearLayout) findViewById(R.id.linebar);
        linebar.setVisibility(View.INVISIBLE);
        //showing = (TextView) findViewById(R.id.showing);
        // showing.setVisibility(View.INVISIBLE);
        mQueue = Volley.newRequestQueue(this);
        getproduct();

        //构造适配器
    }
    private void getproduct(){
        final Intent intent = getIntent();
        String data = intent.getStringExtra("ItemID");
      //  System.out.println("http://127.0.0.1:8080/ebayproduct?"+data);
        addRequest("https://vocal-clone-237107.appspot.com/details?ItemID="+data, new Listener() {
            @Override
            public void response(String response) {
                //textView.setText(response);

                TextView tile = (TextView) findViewById(R.id.text_title);


              //  showing.setVisibility(View.VISIBLE);
                System.out.println((response));



                Gson gson=new Gson();
                // String myJson=   gson.toJson(response);
                // System.out.println(myJson);
                detailPro jsonObj = gson.fromJson(response,detailPro.class);
                currentpro = jsonObj;
                tile.setText(jsonObj.getItem().getTitle());

             //   initData(jsonObj);
              //  initView();
                final Intent intent2 = getIntent();
                String data2 = intent.getStringExtra("ItemID");
                addRequest("https://vocal-clone-237107.appspot.com/similar?itemId="+data2, new Listener() {
                    @Override
                    public void response(String response) {

                        System.out.println((response));





                        Gson gson=new Gson();

                        SimilarPro jsonObj = gson.fromJson(response,SimilarPro.class);

                            sp = jsonObj;




                final Intent intent1 = getIntent();
                String data1 = intent.getStringExtra("title");
                addRequest("https://vocal-clone-237107.appspot.com/photo?title="+data1, new Listener() {
                    @Override
                    public void response(String response) {
                        //textView.setText(response);
                        pb =(ProgressBar) findViewById(R.id.progressBar);
                        pb.setVisibility(View.INVISIBLE);
                        pt = (TextView) findViewById(R.id.progresstext);
                        pt.setVisibility(View.INVISIBLE);
                        System.out.println((response));
                        linebar.setVisibility(View.VISIBLE);




                        Gson gson=new Gson();
                        // String myJson=   gson.toJson(response);
                        // System.out.println(myJson);
                        GooglePhoto jsonObj = gson.fromJson(response,GooglePhoto.class);


                        gp=jsonObj;
                        generate();
                        //   initData(jsonObj);
                        //  initView();

                    }



                });

                    }



                });
            }



        });

    }



    public  void generate(){
        List<Fragment> fragments=new ArrayList<Fragment>();
        final Intent intent = getIntent();
        String data = intent.getStringExtra("shippingcost");

        fragments.add(new Fragment1(currentpro,data));
        fragments.add(new Fragment2(currentpro,data));
        fragments.add(new Fragment3(gp));
        fragments.add(new Fragment4(sp));
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragments);

        //设定适配器
        vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);



        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {//当前页
                Button p = (Button) findViewById(R.id.productbtn);
                Button g = (Button) findViewById(R.id.google);
                Button s = (Button) findViewById(R.id.similar);
                Button sh = (Button) findViewById(R.id.shipdetail);
                switch (position) {
                    case 0:
                        vp.setCurrentItem(0, true);
                        p.setTextColor(Color.LTGRAY);
                        g.setTextColor(Color.parseColor("#9B7D7D"));
                        s.setTextColor(Color.parseColor("#9B7D7D"));
                        sh.setTextColor(Color.parseColor("#9B7D7D"));
                        break;
                    case 1:
                        vp.setCurrentItem(1, true);
                        sh.setTextColor(Color.LTGRAY);
                        g.setTextColor(Color.parseColor("#9B7D7D"));
                        s.setTextColor(Color.parseColor("#9B7D7D"));
                        p.setTextColor(Color.parseColor("#9B7D7D"));
                        break;
                    case 2:
                        vp.setCurrentItem(2, true);
                        g.setTextColor(Color.LTGRAY);
                        p.setTextColor(Color.parseColor("#9B7D7D"));
                        s.setTextColor(Color.parseColor("#9B7D7D"));
                        sh.setTextColor(Color.parseColor("#9B7D7D"));
                        break;
                    case 3:
                        vp.setCurrentItem(3, true);
                        s.setTextColor(Color.LTGRAY);
                        g.setTextColor(Color.parseColor("#9B7D7D"));
                        p.setTextColor(Color.parseColor("#9B7D7D"));
                        sh.setTextColor(Color.parseColor("#9B7D7D"));
                        break;

                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });




    }

    private void addRequest(String url, final Listener listener) {
        final StringRequest stringRequest2 = new StringRequest(Request.Method.GET,url,new Response.Listener<String>() {
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

    public void ToFacebook(View source){
        String url ="https://www.facebook.com/sharer/sharer.php?u=";
        url+= currentpro.getItem().getViewItemURLForNaturalSearch()+ "&quote=Buy "+ currentpro.getItem().getTitle()+ " at $"+  currentpro.getItem().getCurrentPrice().getValue()+ " from link below.";
        System.out.println(url);
        Uri uri = Uri.parse(url);    //设置跳转的网站
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public  void backPro(View source){
       // ConstraintLayout cs = (ConstraintLayout) findViewById(R.id.prore);
       // cs.setVisibility(View.VISIBLE);
        Detail.this.finish();
    }
    public void addCar(View source){
        ImageView img =(ImageView) findViewById(R.id.shopping);
        if (img.getTag().equals("no"))
        {
            img.setImageResource(R.drawable.cartremove);
            img.setTag("yes");
        }
        else
        {
            img.setImageResource(R.drawable.cartplus);
            img.setTag("no");
        }

    }

    public void fraChange(View v) {
        Button p = (Button) findViewById(R.id.productbtn);
        Button g = (Button) findViewById(R.id.google);
        Button s = (Button) findViewById(R.id.similar);
        Button sh = (Button) findViewById(R.id.shipdetail);
        switch (v.getId()) {
            case R.id.productbtn:
                vp.setCurrentItem(0, true);
                ((Button) v).setTextColor(Color.LTGRAY);
                g.setTextColor(Color.parseColor("#9B7D7D"));
                s.setTextColor(Color.parseColor("#9B7D7D"));
                sh.setTextColor(Color.parseColor("#9B7D7D"));
                break;
            case R.id.shipdetail:
                vp.setCurrentItem(1, true);
                ((Button) v).setTextColor(Color.LTGRAY);
                g.setTextColor(Color.parseColor("#9B7D7D"));
                s.setTextColor(Color.parseColor("#9B7D7D"));
                p.setTextColor(Color.parseColor("#9B7D7D"));
                break;
            case R.id.google:
                vp.setCurrentItem(2, true);
                ((Button) v).setTextColor(Color.LTGRAY);
                p.setTextColor(Color.parseColor("#9B7D7D"));
                s.setTextColor(Color.parseColor("#9B7D7D"));
                sh.setTextColor(Color.parseColor("#9B7D7D"));
                break;
            case R.id.similar:
                vp.setCurrentItem(3, true);
                ((Button) v).setTextColor(Color.LTGRAY);
                g.setTextColor(Color.parseColor("#9B7D7D"));
                p.setTextColor(Color.parseColor("#9B7D7D"));
                sh.setTextColor(Color.parseColor("#9B7D7D"));
                break;
        }
    }




}
