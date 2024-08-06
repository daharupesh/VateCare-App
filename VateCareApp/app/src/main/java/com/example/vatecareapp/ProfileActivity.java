package com.example.vatecareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    Button button;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        button = findViewById(R.id.logout);
        firebaseAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(ProfileActivity.this,Sign_In.class));
                Toast.makeText(ProfileActivity.this, "Logout Done", Toast.LENGTH_SHORT).show();
            }
        });
    }

}