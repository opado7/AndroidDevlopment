package com.example.chapter10;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;

public class Self1001_SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.self1001_second);

        String str;
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        TextView textView = (TextView) findViewById(R.id.radioResult);

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Button btnReport = (Button) findViewById(R.id.btnReport);
        btnReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (checkedRadioButtonId != -1) {
                    RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
                    String selectedText = checkedRadioButton.getText().toString();
                    textView.setText(selectedText);
                } else {
                    // Handle case where no radio button is checked
                    textView.setText("No item selected");
                }
            }
        });

    }
}
