package com.elif.traveltheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Register extends AppCompatActivity {
    EditText mFullName, mUsername, mEmail,mPassword, mPhone;
    Button mRegister, mLogin;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mUsername = findViewById(R.id.username);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegister = findViewById(R.id.register);
        mLogin = findViewById(R.id.login);
        mProgressBar = findViewById(R.id.progressBar);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String fullName = mFullName.getText().toString().trim();
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required!");
                    return;
                }
                if (TextUtils.isEmpty(fullName)){
                    mFullName.setError("Full Name is required!");
                    return;
                }
                if (TextUtils.isEmpty(username)){
                    mUsername.setError("Username is required!");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required!");
                    return;
                }

                if (password.length() < 4){
                    mPassword.setError("Password must be greater than 4 characters!");
                    return;
                }
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });
    }
}
