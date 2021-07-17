package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
   // EditText mUsername,mPassword;
    Button mLogin,mNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EditText mUser = (EditText)findViewById(R.id.editUser);
        EditText mPass = (EditText)findViewById(R.id.editPass);


        mLogin=findViewById(R.id.Login_btn);
        mNewUser=findViewById(R.id.signUp_screen);


    }

    public void NewUser(View view) {
        Intent intent=new Intent(login.this,signUp.class);
        startActivity(intent);
    }

    public void Login(View view) {
        Intent intent=new Intent(login.this,Dashboard.class);
        startActivity(intent);
    }
}