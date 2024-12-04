package com.example.chapter08;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Self0801 extends AppCompatActivity {

    CalendarView calendarView;
    EditText edtDiary;
    Button btnWrite, btnLoad, btnCancel;
    String fileName, str;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0801);
        setTitle("간단 일기장");

        calendarView = (CalendarView) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)  {

               str = null;

                String caldate = Integer.toString(year)+ "_" + Integer.toString(month) + "_" +Integer.toString(dayOfMonth);

                str = readDiary(caldate);

                if(str == null)  {
                    edtDiary.setHint("일기 없음");
                    return;
                }


            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName,
                            Context.MODE_PRIVATE);
                    String str1 = edtDiary.getText().toString();
                    outFs.write(str1.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),
                            fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = null;
                edtDiary.setHint("일기 없음");
            }
        });
    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
        } catch (IOException e) {
            return null;
        }
        return diaryStr;
    }
}
