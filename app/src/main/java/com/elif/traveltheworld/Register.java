package com.elif.traveltheworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    public static final String TAG = "TAG";
    private Button login;
    EditText mFullName, mUsername, mEmail,mPassword, mPhone;
    Button mRegister, mLogin;
    ProgressBar mProgressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
     public static HashMap<String,Object> user = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

        mFullName = findViewById(R.id.fullName);
        mUsername = findViewById(R.id.username);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegister = findViewById(R.id.register);
        mLogin = findViewById(R.id.login);

        mProgressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = mEmail.getText().toString().trim();
                final String fullName = mFullName.getText().toString().trim();
                final String username = mUsername.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();
                final String phone = mPhone.getText().toString().trim();

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

                if (password.length() < 6){
                    mPassword.setError("Password must be equal or greater than 6 characters!");
                    return;
                }
                mProgressBar.setVisibility(View.VISIBLE);

                //Registeration

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            user.put("fName", fullName);
                            user.put("uName",username);
                            user.put("email",email);
                            user.put("pWord",password);
                            user.put("phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: Profile created for user: "+ userID);

                                }
                            });


                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
