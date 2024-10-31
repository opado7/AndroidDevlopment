package com.example.chapter07;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Self0701 extends AppCompatActivity {
    EditText edtAngle;
    ImageView imageView1;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0701_main);
        setTitle("제주도 풍경");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu0701_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.itemRotate) {
            imageView1.setRotation(Float.parseFloat(edtAngle.getText().toString()));
            return true;
        } else if (item.getItemId()==R.id.item1) {
            imageView1.setImageResource(R.drawable.jeju2);
            return true;
        } else if (item.getItemId()==R.id.item2) {
            imageView1.setImageResource(R.drawable.jeju14);
            return true;
        } else if (item.getItemId()==R.id.item3) {
            imageView1.setImageResource(R.drawable.jeju6);
            return true;
        } else if (item.getItemId()==R.id.double_big) {
            imageView1.setScaleX(2);
            imageView1.setScaleY(2);
        } else if (item.getItemId()==R.id.double_small) {
            imageView1.setScaleX(0.5f);
            imageView1.setScaleY(0.5f);
        } else if (item.getItemId()==R.id.double_org) {
            imageView1.setScaleX(1);
            imageView1.setScaleY(1);
        }
        return false;
    }
}