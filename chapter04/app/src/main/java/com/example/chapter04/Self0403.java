package com.example.chapter04;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Self0403 extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String num1, num2;
    Integer result, convertnum1, convertnum2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0403_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try{
                    convertnum1 = Integer.parseInt(num1);
                    convertnum2 = Integer.parseInt(num2);

                    result = convertnum1 + convertnum2;

                    textResult.setText("계산 결과 : " + result.toString());

                    Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();

                } catch(NumberFormatException e) {
                    textResult.setText("오류!");
                    Toast.makeText(getApplicationContext(), "숫자만 입력하실 수 있습니다!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try{
                    convertnum1 = Integer.parseInt(num1);
                    convertnum2 = Integer.parseInt(num2);

                    result = convertnum1 - convertnum2;

                    textResult.setText("계산 결과 : " + result.toString());

                    Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();

                } catch(NumberFormatException e) {
                    textResult.setText("오류!");
                    Toast.makeText(getApplicationContext(), "숫자만 입력하실 수 있습니다!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                try{
                    convertnum1 = Integer.parseInt(num1);
                    convertnum2 = Integer.parseInt(num2);

                    result = convertnum1 * convertnum2;

                    textResult.setText("계산 결과 : " + result.toString());

                    Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();

                } catch(NumberFormatException e) {
                    textResult.setText("오류!");
                    Toast.makeText(getApplicationContext(), "숫자만 입력하실 수 있습니다!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                try{
                    convertnum1 = Integer.parseInt(num1);
                    convertnum2 = Integer.parseInt(num2);

                    result = convertnum1 / convertnum2;

                    textResult.setText("계산 결과 : " + result.toString());

                    Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();

                } catch(NumberFormatException e) {
                    textResult.setText("오류!");
                    Toast.makeText(getApplicationContext(), "숫자만 입력하실 수 있습니다!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        btnRem.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                try{
                    convertnum1 = Integer.parseInt(num1);
                    convertnum2 = Integer.parseInt(num2);

                    result = convertnum1 % convertnum2;

                    textResult.setText("계산 결과 : " + result.toString());

                    Toast.makeText(getApplicationContext(), ""+result, Toast.LENGTH_SHORT).show();

                } catch(NumberFormatException e) {
                    textResult.setText("오류!");
                    Toast.makeText(getApplicationContext(), "숫자만 입력하실 수 있습니다!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

}
