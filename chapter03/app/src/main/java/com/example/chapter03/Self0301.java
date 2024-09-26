package com.example.chapter03;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.net.Uri;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Self0301 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0301_main);

        EditText answer, puttext;
        Button printanswer;

        answer = (EditText) findViewById(R.id.answer);
        puttext = (EditText) findViewById(R.id.puttext);
        printanswer = (Button) findViewById(R.id.printanswer);

        printanswer.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "하나", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
