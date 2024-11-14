package com.example.chapter09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1_org) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Self0901_org.class) ;

                startActivity(intent) ;
            }
        });

        Button button1_org = (Button) findViewById(R.id.button1);
        button1_org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Self0901.class);

                startActivity(intent);
            }
        });

        Button button2_org = (Button) findViewById(R.id.button2_org);
        button2_org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Self0902_org.class);

                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Self0902.class);

                startActivity(intent);
            }
        });

        Button button_ex = (Button) findViewById(R.id.ex_button);
        button_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex.class);

                startActivity(intent);
            }
        });


    }
}