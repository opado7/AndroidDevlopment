package com.example.chapter04;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class exercise_08 extends AppCompatActivity {

    EditText firsttext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("연습문제 4-8");
        setContentView(R.layout.exercise_08);

        firsttext = (EditText) findViewById(R.id.exeredit_text);

        firsttext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                 Toast.makeText(getApplicationContext(), firsttext.getText().toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

}
