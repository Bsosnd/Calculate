package com.example.calculate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    private int[] pay;
    private int total;
    private int user_num;
    LinearLayout sub_main;

//    public void setArray(int[] money, int sum,int num){
//        this.user_num=num;
//        this.pay = money;
//        this.total = sum;
//    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_main);

        Intent intent = getIntent();
        pay = intent.getIntArrayExtra("pay");
        total =intent.getIntExtra("total",1024);
        user_num = intent.getIntExtra("user_num",1024);

        sub_main = (LinearLayout)findViewById(R.id.sub_main);

        TextView tt = new TextView(this);
        tt.setText("날짜"+"정산결과");
        tt.setTextSize(25);
        sub_main.addView(tt);

        TextView tm = new TextView(this);
        tm.setText("총 금액 : "+total);
        sub_main.addView(tm);

        //LinearLayout 정의
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        for(int i=0;i<user_num;i++){
            //LinearLayout 생성
            LinearLayout ly = new LinearLayout(this);
            ly.setLayoutParams(params);
            ly.setOrientation(LinearLayout.HORIZONTAL);

            //ImageView 생성
            LinearLayout ivly = new LinearLayout(this);
            ivly.setOrientation(LinearLayout.VERTICAL);
            ivly.setLayoutParams(params);

            ImageView siv = new ImageView(this);
            siv.setImageResource(R.drawable.user);
            LinearLayout.LayoutParams sivlp = new LinearLayout.LayoutParams(100,100);
            sivlp.gravity= Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL;
            siv.setLayoutParams(sivlp);
            ivly.addView(siv);

            TextView stiv = new TextView(this);
            stiv.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
            stiv.setText("이름");
            ivly.addView(stiv);

            ivly.setPadding(0,30,10,0);
            ly.addView(ivly);

            //TextView 생성
            TextView tv = new TextView(this);
            int m = total/5-pay[i];
            System.out.println("m값은 :"+m);
            SpannableString s;
            if(m>0){
            //tv.setText("은   "+m+"원을 더 내야함");
                s = new SpannableString("은  "+m+"원을 더 내야함");
                s.setSpan(new RelativeSizeSpan(1.8f),3,s.length()-8,0);
                s.setSpan(new ForegroundColorSpan(Color.parseColor("#62ABD9")),3,s.length()-8,0);
                tv.setText(s);
            } else if (m == 0) {
                tv.setText("이름"+"은 정산완료");
            } else {
                //tv.setText("이름" + "은" + Math.abs(m) + "원을 받아야 함");
                s = new SpannableString("은  "+Math.abs(m) + "원을 받아야 함");
                s.setSpan(new RelativeSizeSpan(1.8f),3,s.length()-8,0);
                s.setSpan(new ForegroundColorSpan(Color.parseColor("#62ABD9")),3,s.length()-8,0);
                tv.setText(s);
            }
            tv.setTextSize(18);
            tv.setPadding(10,30,30,30);
            tv.setLayoutParams(params);
            ly.addView(tv);

            sub_main.addView(ly);
        }

    }
}

