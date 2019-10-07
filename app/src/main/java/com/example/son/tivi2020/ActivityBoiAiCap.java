package com.example.son.tivi2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityBoiAiCap extends AppCompatActivity {
    private EditText nameUser;
    private Button btnResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boi_ai_cap);
        nameUser = (EditText) findViewById(R.id.nameUser);
        btnResult = (Button) findViewById(R.id.btn_result);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameUser.getText().toString();
                Intent intent = new Intent(ActivityBoiAiCap.this, ActivityResult.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }


}
