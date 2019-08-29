package com.example.hw9;
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
import com.wssholmes.stark.circular_score.*;
import android.text.*;
import android.text.method.*;
import android.text.style.*;
import android.content.DialogInterface.*;
import android.graphics.drawable.*;
import android.app.ActionBar.*;

public class Fragment2 extends Fragment {
    private LinearLayout mGallery;
    private List<String> mImgIds = new ArrayList<String>();
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;
    private View view;
    private detailPro jsonObj;
    private String shippingcost;

    public Fragment2(detailPro jsonObj, String shippingcost) {
        this.jsonObj = jsonObj;
        this.shippingcost = shippingcost;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.layout2, container, false);
        generate();
        return view;
    }

    public void generate() {
        int h = 90;
        TableLayout high = (TableLayout) view.findViewById(R.id.sold);
        if (jsonObj.getItem().getStorefront() != null && jsonObj.getItem().getStorefront().getStoreName() != null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Store Name");
            text.setClickable(true);
            text.setTextColor(Color.BLACK);

            text.setGravity(Gravity.LEFT); //居中显示
            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setHeight(h);
            text_b.setText("");
            text_b.setWidth(100);
            row.addView(text_b);
            TextView text1 = new TextView(this.getContext());

            //设置显示内容
            // text1.setText(jsonObj.getItem().getStorefront().getStoreName());

            text1.setTextColor(Color.parseColor("#673AB7"));

            SpannableString ss = new SpannableString(jsonObj.getItem().getStorefront().getStoreName());
            ss.setSpan(new URLSpan(jsonObj.getItem().getStorefront().getStoreURL()), 0, jsonObj.getItem().getStorefront().getStoreName().length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


            text1.setText(ss);
            text1.setMovementMethod(LinkMovementMethod.getInstance());
            text1.setGravity(Gravity.LEFT); //居中显示


            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }
        if (jsonObj.getItem().getSeller().getFeedbackScore() != null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Feedback Score");
            text.setGravity(Gravity.LEFT);
            text.setTextColor(Color.BLACK);

            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            TextView text1 = new TextView(this.getContext());

            //设置显示内容
            text1.setText(jsonObj.getItem().getSeller().getFeedbackScore());


            text1.setGravity(Gravity.LEFT); //居中显示
            text1.setSingleLine(false);


            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }


        if (jsonObj.getItem().getSeller().getPositiveFeedbackPercent() != null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Popularity");
            text.setGravity(Gravity.LEFT);
            text.setTextColor(Color.BLACK);
            //居中显示
            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            TextView text1 = new TextView(this.getContext());

            //设置显示内容
            //  CircularScoreView circularScoreView = new CircularScoreView(this.getContext(),null);
            int g = (Double.valueOf(jsonObj.getItem().getSeller().getPositiveFeedbackPercent())).intValue();
            // circularScoreView.setScore(g);
            // text1.setText(jsonObj.getItem().getBrand());
            //  circularScoreView.setPrimaryColor(Color.RED);

            View view1 = LayoutInflater.from(row.getContext()).inflate(R.layout.circlescore, row,
                    false);
            // text1.setGravity(Gravity.LEFT); //居中显示
            //  text1.setSingleLine(false);

            CircularScoreView circularScoreView = (CircularScoreView) view1.findViewById(R.id.two);
            circularScoreView.setScore(g);
            circularScoreView.setPrimaryColor(Color.RED);
             circularScoreView.setBackgroundColor(Color.WHITE);
            circularScoreView.setTextColor(Color.BLACK);

            //添加到Row
            row.addView(view1);

            //将一行数据添加到表格中
            high.addView(row);
        }

        if (jsonObj.getItem().getSeller().getFeedbackRatingStar() != null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Feedbcak Star");
            text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);
            //居中显示
            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            ImageView text1 = new ImageView(this.getContext());
            Drawable drawable;
            if (Integer.parseInt(jsonObj.getItem().getSeller().getFeedbackScore()) < 5000) {

             //   text1.setImageResource(R.drawable.starcircleoutline);
                drawable = ContextCompat.getDrawable(row.getContext(), R.drawable.starcircleoutline);
            } else {
                // console.log(product.sellerInfo[0].feedbackRatingStar[0].split("Sh")[0]);
              //  text1.setImageResource(R.drawable.starcircle);
                drawable = ContextCompat.getDrawable(row.getContext(), R.drawable.starcircle);
            }

         //   Drawable drawable = ContextCompat.getDrawable(context, R.drawable.);
            Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(wrappedDrawable, ContextCompat.getColor(row.getContext(),getResources().getIdentifier(jsonObj.getItem().getSeller().getFeedbackRatingStar(), "color", this.getContext().getPackageName())));
            text1.setImageDrawable(wrappedDrawable);

            text1.setScaleType(ImageView.ScaleType.FIT_START);

            //text1.setGravity(Gravity.LEFT);
            //添加到Row
            row.addView(text1);
            text1.setPadding(0,0,60,0);

            //将一行数据添加到表格中
            high.addView(row);
        }


        //-------------------------
        high = (TableLayout) view.findViewById(R.id.shipinfo);
        String ss;
        if ("0.0".equals(shippingcost)) {
            ss="Free Shipping" ;
        }
        else{
            ss="$"+ shippingcost;
        }

        //if (jsonObj.getItem().getStorefront()!=null &&jsonObj.getItem().getStorefront().getStoreName()!=null) {
            //创建一行
            TableRow row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Shipping Cost");
            text.setTextColor(Color.BLACK);




            text.setGravity(Gravity.LEFT); //居中显示
            row.addView(text);
            TextView text_b = new TextView(this.getContext());
            text_b.setText("");
        text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            TextView text1 = new TextView(this.getContext());

            //设置显示内容
            // text1.setText(jsonObj.getItem().getStorefront().getStoreName());

           // text1.setTextColor(Color.parseColor("#CA00F4"));

            text1.setText(ss);
            text1.setGravity(Gravity.LEFT); //居中显示



            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);


            if (jsonObj.getItem().getGlobalShipping()!=null) {
            //创建一行
             row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Global Shipping");

                text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);


            row.addView(text);
            text_b = new TextView(this.getContext());
            text_b.setText("");
                text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
             text1 = new TextView(this.getContext());

            //设置显示内容
                if (jsonObj.getItem().getGlobalShipping().equals("false")) {
                    text1.setText("No");
                }
                else
                {
                    text1.setText("Yes");
                }


            text1.setGravity(Gravity.LEFT); //居中显示
            text1.setSingleLine(false);



            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }


        if (jsonObj.getItem().getHandlingTime()!=null) {
            //创建一行
            row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
             text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Handling Time");
            text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);
            //居中显示
            row.addView(text);
            text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
             text1 = new TextView(this.getContext());


            if (jsonObj.getItem().getHandlingTime().equals("0") || jsonObj.getItem().getHandlingTime().equals("1"))
            {
                text1.setText(jsonObj.getItem().getHandlingTime()+ " day");
            }
            else
            {
                text1.setText(jsonObj.getItem().getHandlingTime()+ " days");
            }

            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }
        if (jsonObj.getItem().getConditionDisplayName()!=null) {
            //创建一行
            row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Condition");
            text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);
            //居中显示
            row.addView(text);
            text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            text1 = new TextView(this.getContext());


                text1.setText(jsonObj.getItem().getConditionDisplayName());


            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }
        //----------------------------

        high = (TableLayout) view.findViewById(R.id.returnpolicy);
        if (jsonObj.getItem().getReturnPolicy().getReturnsAccepted()!=null) {
            //创建一行
            row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Policy");
            text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);
            //居中显示
            row.addView(text);
            text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            text1 = new TextView(this.getContext());


            text1.setText(jsonObj.getItem().getReturnPolicy().getReturnsAccepted());


            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }


        if (jsonObj.getItem().getReturnPolicy().getReturnsWithin()!=null) {
            //创建一行
            row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Returns within");
            text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);


            row.addView(text);
            text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            text1 = new TextView(this.getContext());

            //设置显示内容

                text1.setText(jsonObj.getItem().getReturnPolicy().getReturnsWithin());


            text1.setGravity(Gravity.LEFT); //居中显示
            text1.setSingleLine(false);



            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }


        if (jsonObj.getItem().getReturnPolicy().getRefund()!=null) {
            //创建一行
            row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Refund Mode");
            text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);
            //居中显示
            row.addView(text);
            text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            text1 = new TextView(this.getContext());
            text1.setSingleLine(false);
            text1.setMaxWidth(700);



                text1.setText(jsonObj.getItem().getReturnPolicy().getRefund());


            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }
        if (jsonObj.getItem().getReturnPolicy().getShippingCostPaidBy()!=null) {
            //创建一行
            row = new TableRow(this.getContext());

            //创建显示的内容,这里创建的是一列
            text = new TextView(this.getContext());

            //设置显示内容
            text.setText("Shipped by");
            text.setTextColor(Color.BLACK);
            text.setGravity(Gravity.LEFT);
            //居中显示
            row.addView(text);
            text_b = new TextView(this.getContext());
            text_b.setText("");
            text_b.setHeight(h);
            text_b.setWidth(100);
            row.addView(text_b);
            text1 = new TextView(this.getContext());


            text1.setText(jsonObj.getItem().getReturnPolicy().getShippingCostPaidBy());


            //添加到Row
            row.addView(text1);

            //将一行数据添加到表格中
            high.addView(row);
        }
    }
}

