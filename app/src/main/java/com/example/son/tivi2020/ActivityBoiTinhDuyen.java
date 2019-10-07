package com.example.son.tivi2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class ActivityBoiTinhDuyen extends AppCompatActivity {
    private EditText nameMen;
    private TextView birthDayMen;
    private ImageButton imageButton1;
    private EditText nameWomen;
    private TextView birthDayWomen;
    private ImageButton imageButton2;
    private Button btnResult;
    private DatePickerDialog.OnDateSetListener mDataSetListener1;
    private DatePickerDialog.OnDateSetListener mDataSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boi_tinh_duyen);


        nameMen = (EditText) findViewById(R.id.nameMen);
        birthDayMen = (TextView) findViewById(R.id.birthDayMen);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        nameWomen = (EditText) findViewById(R.id.nameWomen);
        birthDayWomen = (TextView) findViewById(R.id.birthDayWomen);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        btnResult = (Button) findViewById(R.id.btn_result);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ActivityBoiTinhDuyen.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDataSetListener1, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDataSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                String date = i2 + "/" + i1 + "/"+i;
                birthDayMen.setText(date);

            }
        };

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ActivityBoiTinhDuyen.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDataSetListener2, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDataSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                String date = i2 + "/" + i1 + "/"+i;
                birthDayWomen.setText(date);

            }
        };

    }

}
