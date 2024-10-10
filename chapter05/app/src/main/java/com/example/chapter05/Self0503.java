package com.example.chapter05;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Self0503 extends AppCompatActivity {

    long mNow;
    Date mDate;
    SimpleDateFormat full_sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss");

    private String getDate(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return full_sdf.format(mDate);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(255, 255, 255));
        setContentView(baseLayout, params);

        EditText text = new EditText(this);
        text.setText("강원대");
        baseLayout.addView(text);

        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.rgb(255, 255, 0));
        baseLayout.addView(btn);

        TextView showtext = new TextView(this);
        showtext.setText("텍스트뷰입니다.");
        showtext.setTextSize(25);
        baseLayout.addView(showtext);

        Button date_btn = new Button(this);
        date_btn.setText("날짜시간 버튼입니다");
        date_btn.setBackgroundColor(Color.rgb(255, 255, 0));
        baseLayout.addView(date_btn);

        EditText Date_text = new EditText(this);
        Date_text.setText("여기에 날짜, 시간이 나타납니다.");
        baseLayout.addView(Date_text);



        TextView txt = new TextView(this);
        baseLayout.addView(txt);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String showtext2 = text.getText().toString();
                showtext.setText(showtext2);
            }
        });

        date_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Date_text.setText(getDate());
            }
        });

    }


}
