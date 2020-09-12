package com.example.mobileassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    TextView loginLink;
    EditText mName,mEmail,mPassword,mConfirmPassword;
    Button register_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        mName = findViewById(R.id.username);
        mEmail=findViewById(R.id.email);
        mPassword=findViewById(R.id.password);
        mConfirmPassword=findViewById(R.id.confirmPassword);
        register_btn=findViewById(R.id.registerButton);
        loginLink=findViewById(R.id.loginLink);

        // to check if the user already login or not
        if(mAuth.getCurrentUser() !=null){
            Intent intent=new Intent(Register.this,MainActivity.class);
            startActivity(intent);
        }

        register_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name=mName.getText().toString().trim();
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();
                String confirmPassword=mConfirmPassword.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    mName.setError("Username is required.");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required.");
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    mConfirmPassword.setError("Password is required.");
                    return;
                }

                if(password.length()<7){
                    mPassword.setError("Password must be at least 7 or more character.");
                    return;
                }
                String numbers = "(.*[0-9].*)";
                if(!password.matches(numbers)){
                    mPassword.setError("Password must contain at least one number");
                    return;
                }

                if(confirmPassword != null && !confirmPassword.equals(password)){
                    mConfirmPassword.setError("Password and password confirmation is not match ");
                    return;
                }

                //register user in firebase

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                openLogin();
            }

            public void openLogin(){
                Intent intent=new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }
}