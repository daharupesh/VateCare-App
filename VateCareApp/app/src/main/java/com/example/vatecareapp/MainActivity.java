package com.example.vatecareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean isAndroidReady;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnLoginPage);
        View content = findViewById(android.R.id.content);
        content.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (isAndroidReady) {
                    content.getViewTreeObserver().removeOnPreDrawListener(this);

                }
                showContentAftersomeTime();
                return false;
            }

            private void showContentAftersomeTime() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isAndroidReady = true;

                    }
                }, 2000);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Sign_In.class));
            }
        });


    }
}


