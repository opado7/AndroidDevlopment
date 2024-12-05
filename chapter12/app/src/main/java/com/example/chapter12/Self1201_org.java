package com.example.chapter12;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Self1201_org extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect, btnChange, btnDelete;
    SQLiteDatabase sqlDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self1201_org);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnChange = (Button) findViewById(R.id.btnChange);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        myHelper = new myDBHelper(this);
        btnInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력하면 됨.
                sqlDB.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                if(edtName.getText().toString().isEmpty() || edtNumber.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "빈칸으로 입력 할 수 없습니다.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                while(cursor.moveToNext()){
                    if(edtName.getText().toString().equals(cursor.getString(0))){
                        Toast.makeText(getApplicationContext(), "이미 등록된 그룹입니다.",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                        + edtName.getText().toString() + "' , "
                        + edtNumber.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                sqlDB.execSQL("UPDATE groupTBL SET gName= " +
                        "'" + edtName.getText().toString() + "', gNumber= "
                        + edtNumber.getText().toString() +
                        " WHERE gName= '" + edtName.getText().toString() + "';");
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName= '" + edtName.getText().toString() + "';");
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strNames = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                cursor.close();
            }
        });

    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE  groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }

    }
}
