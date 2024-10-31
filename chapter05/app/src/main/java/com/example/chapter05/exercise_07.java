package com.example.chapter05;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class exercise_07 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout base_layout = new LinearLayout(this);
        base_layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(base_layout, params);

        params.weight = 1;

        LinearLayout layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.HORIZONTAL);
        layout1.setBackgroundColor(Color.rgb(255, 0, 0));

        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.VERTICAL);
        layout2.setBackgroundColor(Color.rgb(0, 0, 255));
        layout2.setWeightSum(1);

        LinearLayout layout1_1 = new LinearLayout(this);
        layout1_1.setOrientation(LinearLayout.VERTICAL);

        LinearLayout layout1_2 = new LinearLayout(this);
        layout1_2.setOrientation(LinearLayout.VERTICAL);

        LinearLayout layout2_1 = new LinearLayout(this);
        layout2_1.setOrientation(LinearLayout.VERTICAL);
        layout2_1.setBackgroundColor(Color.YELLOW);

        LinearLayout layout2_2 = new LinearLayout(this);
        layout2_2.setOrientation(LinearLayout.VERTICAL);
        layout2_2.setBackgroundColor(Color.BLACK);

        base_layout.addView(layout1, params);
        base_layout.addView(layout2, params);
        layout1.addView(layout1_1, params);
        layout1.addView(layout1_2, params);
        layout1_2.addView(layout2_1, params);
        layout1_2.addView(layout2_2, params);

    }
}
