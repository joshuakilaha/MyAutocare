package com.example.myautocare.Activities.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myautocare.Admin.AdminLogin;
import com.example.myautocare.R;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button login;
    TextView signup,admin,forgot_password;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email  = findViewById(R.id.user_email);
        password = findViewById(R.id.user_password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        forgot_password = findViewById(R.id.forgot_password);
        admin = findViewById(R.id.admin);
        checkBox = findViewById(R.id.remember);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////////move to main activity////

            }
        });

        /////checkbox/////


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////forgot password//////
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////to Admin///

                Intent admin_login = new Intent(LoginActivity.this, AdminLogin.class);
                startActivity(admin_login);

            }
        });









    }
}
