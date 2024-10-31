package com.example.chapter04;

import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class exercise_09 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("연습문제 4-9");
        setContentView(R.layout.exercise_09);

        Button spin_button = (Button) findViewById(R.id.spin_button);
        ImageView van = (ImageView) findViewById(R.id.vandark);

        spin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                van.setRotation(van.getRotation() + 15);
            }
        });

    }

}
