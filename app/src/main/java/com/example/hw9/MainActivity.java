package com.example.hw9;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.util.*;
import java.util.*;
import java.lang.*;
import android.content.*;
import android.view.*;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.*;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {

    private CheckBox enable_zip;
    private LinearLayout line1;
    private EditText milesfrom;
    private TextView from;
    private TextView error1;
    private TextView error2;
    private Button searchbtn;
    private Button clearbtn;
    private Button wishlist;
    private Button searchpage;
    private ConstraintLayout page1;
    private ConstraintLayout page2;
    private EditText keyword;
    private EditText zipcode_text;
    private CheckBox new1;
    private CheckBox used;
    private CheckBox unspe;
    private CheckBox local;
    private CheckBox freeship;
    private RadioButton current;
    private RadioButton zipcode;
    private  Spinner category;
    private  String ca;
    private HashMap<String, String> map = new HashMap<String, String>();
    private String current_zip;
    interface Listener {
        void response(String string) throws JSONException;
    }
    RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();//隐藏标题栏
      //  getSupportActionBar().s
        mQueue = Volley.newRequestQueue(MainActivity.this);
        addRequest("http://ip-api.com/json", new Listener() {
            @Override
            public void response(String response) throws JSONException {
                //textView.setText(response);
                System.out.println((response));
              //  System.out.println(response.trim().substring(1,response.length()-1));
                //  JsonReader jsonReader = new JsonReader(new StringReader(response));//其中jsonContext为String类型的Json数据
                //   jsonReader.setLenient(true);
                JSONObject json = new JSONObject(response);
                current_zip= json.getString("zip");
                System.out.println(current_zip);



            }



        });

        initView();

        listener();
    }
    private void addRequest(String url, final Listener listener) {
        final StringRequest stringRequest2 = new StringRequest(Request.Method.GET,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    try {
                        listener.response(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
    private void listener() {

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ca = getResources().getStringArray(R.array.spingarr)[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        enable_zip.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    line1.setVisibility(View.VISIBLE);
                    from.setVisibility(View.VISIBLE);
                    milesfrom.setVisibility(View.VISIBLE);
                    ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) searchbtn.getLayoutParams();
                    DisplayMetrics dm = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(dm);
                    int dp = (int)(520*dm.density + 0.5f);

                 //   final float scale = context.getResources().getDisplayMetrics().density;
                    //由30dp转化来的px
                 //   int px = (int) (dp * scale + 0.5f);

                    lp.topMargin = dp;
                    searchbtn.setLayoutParams(lp);
                    ConstraintLayout.LayoutParams lp1 = (ConstraintLayout.LayoutParams) clearbtn.getLayoutParams();




                    int dp1 = (int)(520*dm.density + 0.5f);
                    lp1.topMargin = dp1;
                    clearbtn.setLayoutParams(lp1);

                } else {
                    DisplayMetrics dm = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(dm);
                    line1.setVisibility(View.INVISIBLE);
                    from.setVisibility(View.INVISIBLE);
                    milesfrom.setVisibility(View.INVISIBLE);
                    ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) searchbtn.getLayoutParams();
                    int dp = (int)(420*dm.density + 0.5f);

                    //   final float scale = context.getResources().getDisplayMetrics().density;
                    //由30dp转化来的px
                    //   int px = (int) (dp * scale + 0.5f);

                    lp.topMargin = dp;
                    searchbtn.setLayoutParams(lp);
                    ConstraintLayout.LayoutParams lp1 = (ConstraintLayout.LayoutParams) clearbtn.getLayoutParams();
                    int dp1 = (int)(420*dm.density + 0.5f);
                    lp1.topMargin = dp1;
                    clearbtn.setLayoutParams(lp1);
                }
            }
        });


    }

    public void wishlist_click(View source){
        page1.setVisibility(View.GONE);
        page2.setVisibility(View.VISIBLE);

    }

    public void search_click(View source){
        page2.setVisibility(View.GONE);
        page1.setVisibility(View.VISIBLE);

    }
    public void submit(View source){
        //System.out.println(ca);
        if (form_validation()) {
            int num = -1;
            String url = "";
            // keywords
            url = url + "keywords=" + keyword.getText().toString();
            //categoryId

            if (!"All".equals(ca))
                url = url + "&categoryId=" + map.get(ca);
            // System.out.println(url);
            if (enable_zip.isChecked()) {
                if (zipcode.isChecked())

                    url = url + "&buyerPostalCode=" + zipcode_text.getText().toString();
                else
                    url = url + "&buyerPostalCode=" + current_zip;


                num = num + 1;
                url = url + "&itemFilter(" + num + ").name=MaxDistance&itemFilter(" + num + ").value=";
                if ("".equals(milesfrom.getText().toString()))
                    url = url + "10";
                else
                    url = url + milesfrom.getText().toString();
            }
            num = num + 1;
            url = url + "&itemFilter(" + num + ").name=HideDuplicateItems&itemFilter(" + num + ").value=true";
            //console.log(document.getElementsByName("condition"))
            ArrayList<CheckBox> id_array = new ArrayList();
            if (new1.isChecked())
                id_array.add(new1);
            if (used.isChecked())
                id_array.add(used);
            if (unspe.isChecked())
                id_array.add(unspe);
            // console.log(id_array);

            if (id_array.size() != 0) {
                // n = -1;

                num = num + 1;
                url = url + "&itemFilter(" + num + ").name=Condition";
                for (int i = 0; i < id_array.size(); i++) {

                    url = url + "&itemFilter(" + num + ").value(" + i + ")=" + id_array.get(i).getText().toString();
                }

            }

            ArrayList<CheckBox> ship_array = new ArrayList();
            if (local.isChecked())
                ship_array.add(local);
            if (freeship.isChecked())
                ship_array.add(freeship);

            //   console.log(ship_array);
            if (ship_array.size() != 0) {
                for (int i = 0; i < ship_array.size(); i++) {
                    num = num + 1;
                    url = url + "&itemFilter(" + num + ").name=" + ship_array.get(i).getText().toString().replace(" ", "") + "Only" + "&itemFilter(" + num + ").value=true";
                }
            }
            System.out.println(url);
            Intent intent = new Intent();
            /* 指定intent要启动的类 */
            intent.setClass(MainActivity.this, ProductActivity.class);
            intent.putExtra("data",url);
            intent.putExtra("smalltitle",keyword.getText().toString());
            /* 启动一个新的Activity */
            startActivity(intent);
            /* 关闭当前的Activity */
           // MainActivity.this.finish();

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please fix all fileds with errors",
                    Toast.LENGTH_SHORT).show();
        }
    }
      public void myclear1(View source){
        enable_zip.setChecked(false);



          error1.setVisibility(View.INVISIBLE);
          error2.setVisibility(View.INVISIBLE);
          milesfrom.setText("");
          keyword.setText("");
          zipcode.setChecked(false);
          new1.setChecked(false);
          used.setChecked(false);
          unspe.setChecked(false);
          local.setChecked(false);
          freeship.setChecked(false);
          current.setChecked(true);
          zipcode.setChecked(false);
          category.setSelection(0,true);
      }
        private boolean form_validation(){
         if ("".equals(keyword.getText().toString()))
         {
             error1.setVisibility(View.VISIBLE);
             return false;
         }
         else {
             error1.setVisibility(View.INVISIBLE);
         }
            if (enable_zip.isChecked() && zipcode.isChecked()&&"".equals(zipcode_text.getText().toString()))
            {
                error2.setVisibility(View.VISIBLE);
                return false;
            }
            else {
                error2.setVisibility(View.INVISIBLE);
            }
            return true;
        }

    private void initView() {

        enable_zip=(CheckBox) findViewById(R.id.nearby);
        line1=(LinearLayout) findViewById(R.id.line1);
        from=(TextView) findViewById(R.id.from);
        error1=(TextView) findViewById(R.id.error1);
        error2=(TextView) findViewById(R.id.error2);
        milesfrom=(EditText) findViewById(R.id.mile);
        searchbtn=(Button) findViewById(R.id.search);
        clearbtn=(Button) findViewById(R.id.clear);
        wishlist=(Button) findViewById(R.id.wishlist);
        searchpage=(Button) findViewById(R.id.searchbtn);
        page1 = (ConstraintLayout) findViewById(R.id.searchpage);
        page2 = (ConstraintLayout) findViewById(R.id.shopcar);
         keyword=(EditText) findViewById(R.id.keyword);
         zipcode_text=(EditText) findViewById(R.id.zipcode_text);
         new1=(CheckBox) findViewById(R.id.new1);
         used=(CheckBox) findViewById(R.id.used);
        unspe=(CheckBox) findViewById(R.id.unspecified);
         local=(CheckBox) findViewById(R.id.local);
         freeship=(CheckBox) findViewById(R.id.freeshipping);
         current =(RadioButton) findViewById(R.id.current);
         zipcode=(RadioButton) findViewById(R.id.zipcode);
         category=(Spinner) findViewById(R.id.category);
         map.put("Art","550");
        map.put("Bady","2984");
        map.put("Books","267");
        map.put("Clothing,Shoes & Accessories","11450");
        map.put("Computers/Tablets & Networking","58058");
        map.put("Health & Beauty","26395");
        map.put("Music","11233");
        map.put("Video Games & Consoles","1249");

    }
}





