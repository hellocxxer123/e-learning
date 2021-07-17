package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button alreadySignBtn,signUpBtn;
    public String Spinner_val;
    EditText regUsername,regEmail,regPhone,regPassword;
    Spinner joinAs;
    private FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String[] join_as={"Student","Instructor"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,join_as);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


        //----------------------------------------------------------------------Assigning id ----------------------------------------------------------------------//
        regUsername=findViewById(R.id.fullname);
        regPassword=findViewById(R.id.password);
        regEmail=findViewById(R.id.email);
        regPhone=findViewById(R.id.phoneNumber);

        joinAs=findViewById(R.id.simpleSpinner);

        alreadySignBtn=findViewById(R.id.already_btn);
        signUpBtn=findViewById(R.id.signup_screenBtn);

        //----------------------------------------------------------------------Already SignUp Listner----------------------------------------------------------------------//

        alreadySignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signUp.this,login.class);
                startActivity(intent);
            }
        });


         //----------------------------------------------------------------------mAuth get Instance----------------------------------------------------------------------//

        mAuth=FirebaseAuth.getInstance();
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Spinner_val=join_as[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

        Toast.makeText(this, " Please select Register as ", Toast.LENGTH_SHORT).show();

    }

    private Boolean validateName()
    {
        String val=regUsername.getText().toString();

        if(!val.isEmpty())
        {
            regUsername.setError(null);
            //regUsername.setErrorEnabled(false);
            return true;
        }
        else
        {
            regUsername.setError("Field cannot be empty");
            return false;
        }
    }

    private Boolean validateEmail()
    {
        String val=regEmail.getText().toString();
        String emailPattern="[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty())
        {
            regEmail.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(emailPattern))
        {
            regEmail.setError("Invalid email address");
            return false;
        }
        else
        {
            regEmail.setError(null);
            return true;
        }
    }

    private Boolean validatePhone()
    {
        String val=regPhone.getText().toString();

        if(val.isEmpty() )
        {
            regPhone.setError("Field cannot be empty");
            return false;
        }
        else if( val.length()<10)
        {
            regPhone.setError("Enter 10 digit phone number");
            return false;
        }
        else
        {
            regPhone.setError(null);
            return true;
        }
    }

    private Boolean validatePassword()
    {
        String val=regPassword.getText().toString();
        String passwordVal= "^"+
                "(?=.*[a-zA-z])"+ //any letter
                "(?=.*[@#$%^&+=])"+ //atleast one special char.
                "(?=\\S+$)"+ //No white space
                ".{4,}"+  //at least 4 char
                "$";


        if(val.isEmpty())
        {
            regPassword.setError("Field cannot be empty");
            return false;

        }
        else if(!val.matches(passwordVal))
        {
            regPassword.setError("Password is too weak");
            return false;
        }
        else
        {

            regPassword.setError(null);
            return true;
        }
    }
    //save data in fire base//
    public void sign_up_click(View view) {
        if(!validateName() | !validateEmail() | !validatePassword() | !validatePhone())
        {
            return;
        }

        String name=regUsername.getText().toString();
        String email=regEmail.getText().toString();
        String phone=regPhone.getText().toString();
        String password=regPassword.getText().toString();




        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("users");
        
        UserHelperClass helperClass=new UserHelperClass(name,email,phone,password,Spinner_val);
        reference.child(phone).setValue(helperClass);

        Toast.makeText(this, "Registered as "+ Spinner_val, Toast.LENGTH_SHORT).show();



        Intent intent =new Intent(signUp.this,login.class);
        startActivity(intent);


    }
    public void alreadySign(View view) {
        Intent intent =new Intent(signUp.this,login.class);
        startActivity(intent);
    }

    // FireBASE Auth//






}