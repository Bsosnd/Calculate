package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Map<Integer,EditText> texts= new HashMap<Integer,EditText>();
    EditText[] texts;
    int sum = 0;
    int[] money;
    LinearLayout layout_calculate;
    LinearLayout layout_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_input = (LinearLayout)findViewById(R.id.layout_input);
        Button btn_calculate = findViewById(R.id.btn_calculate);

        //LinearLayout 정의
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        texts = new EditText[5];
        for(int i=0;i<5;i++){
            //LinearLayout 생성
            LinearLayout ly = new LinearLayout(this);
            ly.setLayoutParams(params);
            ly.setOrientation(LinearLayout.HORIZONTAL);

            //ImageView 생성
            LinearLayout ivly = new LinearLayout(this);
            ivly.setOrientation(LinearLayout.VERTICAL);
            ivly.setLayoutParams(params);

            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.user);
            LinearLayout.LayoutParams ivlp = new LinearLayout.LayoutParams(100,100);
            ivlp.gravity=Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL;
            iv.setLayoutParams(ivlp);
            ivly.addView(iv);

            TextView tiv = new TextView(this);
            tiv.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
            tiv.setText("이름");
            ivly.addView(tiv);

            ly.addView(ivly);



            //EditText 생성
            EditText et = new EditText(this);
            LinearLayout.LayoutParams etlp = new LinearLayout.LayoutParams(300,120);
            etlp.setMargins(30,30,30,30);
            et.setLayoutParams(etlp);
            //et.setId(i);
            //texts.add(i,et);
            texts[i] = et;
            ly.addView(et);

            //TextView 생성
            TextView tv = new TextView(this);
            tv.setText("원");
            LinearLayout.LayoutParams tvlp = new LinearLayout.LayoutParams(50,50);
            tvlp.setMargins(30,30,30,30);
            tv.setLayoutParams(tvlp);
            ly.addView(tv);
            layout_input.addView(ly);
        }

        btn_calculate.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                money = new int[5];

                for(int i=0;i<5;i++){
                    money[i] = Integer.parseInt(texts[i].getText().toString());
                    sum+=money[i];
                }

                Intent intent = new Intent(getApplicationContext(),SubActivity.class);
                intent.putExtra("pay",money);
                intent.putExtra("total",sum);
                intent.putExtra("user_num",5);
                startActivity(intent);

            }
        });

    }

    public void getUsersName(){

    }
}