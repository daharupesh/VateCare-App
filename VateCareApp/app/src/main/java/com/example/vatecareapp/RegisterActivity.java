package com.example.vatecareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputUsername, inputEmail, inputPassword, inputConformPassword;
    private Button btnRegister;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView Loginnow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Loginnow = findViewById(R.id.loginnow);
        inputUsername = findViewById(R.id.inputUsername);
        inputEmail = findViewById(R.id.inputEmail);
        inputConformPassword = findViewById(R.id.inputConformPassword);
        inputPassword = findViewById(R.id.inputPassword);
        btnRegister = findViewById(R.id.btnRegister);
        Loginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, Sign_In.class));
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
//
    }

    private String name, userEmail, password, confirmPassword;

    private void registerUser() {
        name = inputUsername.getText().toString().trim();
        userEmail = inputEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();
        confirmPassword = inputConformPassword.getText().toString().trim();
        createAccount();
    }

    private void createAccount() {
        progressDialog.setTitle("Creating Account...");
        progressDialog.show();
//        Toast.makeText(this, "adfaf", Toast.LENGTH_SHORT).show();

        firebaseAuth.createUserWithEmailAndPassword(userEmail, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
//                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, "Register sucessfull", Toast.LENGTH_SHORT).show();
                saverFirebase();
                progressDialog.hide();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
                progressDialog.hide();
            }
        });
    }

    String timestamp = String.valueOf(TimeUnit.MICROSECONDS.toSeconds(System.currentTimeMillis()));

    private void saverFirebase() {
        progressDialog.setTitle("Saving Info...");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", firebaseAuth.getUid());
        hashMap.put("Email", "" + userEmail);
        hashMap.put("Name", "" + name);
        hashMap.put("Password", "" + password);
        hashMap.put("ConfirmPassword", "" + confirmPassword);
        hashMap.put("timestamp", "" + timestamp);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(firebaseAuth.getUid()).setValue(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        progressDialog.dismiss();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
