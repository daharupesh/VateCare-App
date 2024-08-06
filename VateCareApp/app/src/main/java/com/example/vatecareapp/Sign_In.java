package com.example.vatecareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Sign_In extends AppCompatActivity {
    TextView textView;
    private Button btnLogin, login_google_button;
    private FirebaseAuth mAuth;
    private EditText inputUsername, inputPasswordd;
    SignInButton signInButton;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        View content = findViewById(android.R.id.content);
        textView = findViewById(R.id.txt2);
        btnLogin = findViewById(R.id.btnLogin);
        login_google_button = findViewById(R.id.login_google_button);
        inputUsername = findViewById(R.id.inputUsername);
        inputPasswordd = findViewById(R.id.inputPassword);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        //   when user clicks on login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsr();
            }
            String userEmail, password;
            private void loginUsr() {

                userEmail = inputUsername.getText().toString().trim();
                password = inputPasswordd.getText().toString().trim();
                progressDialog.setTitle("Logging...");
                progressDialog.show();
                mAuth.signInWithEmailAndPassword(userEmail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.dismiss();
                        startActivity(new Intent(Sign_In.this, DashbordActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(Sign_In.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_In.this, RegisterActivity.class);
                startActivity(intent);
                Toast.makeText(Sign_In.this, "Register Page", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
