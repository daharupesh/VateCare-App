package com.example.vatecareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuffaloActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffalo);
        button = findViewById(R.id.Contactdtr);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuffaloActivity.this,DoctorInfoActivity.class));
            }
        });

    }







//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.home_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//       }

}