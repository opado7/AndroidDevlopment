package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Self0402_org extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0402_main_org);
        setTitle("직접 풀어보기 4-2");

        TextView tv1, tv2, tv3;
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);

        tv1.setText("안녕하세요?");
        tv1.setTextColor(Color.RED);
        tv2.setTextSize(30);
        tv2.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
        tv3.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하갸냐댜랴먀뱌샤");
        tv3.setSingleLine();
    }
}
