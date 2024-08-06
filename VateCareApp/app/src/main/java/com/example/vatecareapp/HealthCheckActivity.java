package com.example.vatecareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class HealthCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_check);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void buffalo(View view) {
        startActivity(new Intent(HealthCheckActivity.this,BuffaloActivity.class));
        Toast.makeText(HealthCheckActivity.this, "This is for Buffalo", Toast.LENGTH_SHORT).show();
    }

    public void goat(View view) {
        Toast.makeText(HealthCheckActivity.this, "This is for Goat", Toast.LENGTH_SHORT).show();
    }

    public void cow(View view) {
        Toast.makeText(HealthCheckActivity.this, "This is for Cow", Toast.LENGTH_SHORT).show();
    }

    public void Dog(View view) {
        Toast.makeText(HealthCheckActivity.this, "This is for Dog", Toast.LENGTH_SHORT).show();
    }
}