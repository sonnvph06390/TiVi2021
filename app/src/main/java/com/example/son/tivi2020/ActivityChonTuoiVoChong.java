package com.example.son.tivi2020;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.YearMonth;
import java.util.Calendar;

public class ActivityChonTuoiVoChong extends AppCompatActivity {

    private RadioGroup radiogr;
    private RadioButton radio1;
    private RadioButton radio2;
    private TextView calenderYear;
    private ImageButton imageButton1;
    private TextView lunaryear;
    private Button btnResult;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_tuoi_voi_chong);

        initView();
    }

    private void initView() {
        radiogr = (RadioGroup) findViewById(R.id.radiogr);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        calenderYear = (TextView) findViewById(R.id.calenderYear);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        lunaryear = (TextView) findViewById(R.id.lunaryear);
        btnResult = (Button) findViewById(R.id.btn_result);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityChonTuoiVoChong.this, ActivityBoiTinhDuyen.class));
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog monthDatePickerDialog = new DatePickerDialog(ActivityChonTuoiVoChong.this,
                        AlertDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calenderYear.setText(year+"");
                    }
                }, 2019, 0, 0){
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        getDatePicker().findViewById(getResources().getIdentifier("day","id","android")).setVisibility(View.GONE);
                        getDatePicker().findViewById(getResources().getIdentifier("month","id","android")).setVisibility(View.GONE);
                    }
                };
                monthDatePickerDialog.setTitle("Năm Sinh");
                monthDatePickerDialog.show();

            }

        });
    }
}
