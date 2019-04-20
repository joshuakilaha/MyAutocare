package com.example.myautocare.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myautocare.Admin.AdminViews.BMW.Main2Activity;
import com.example.myautocare.Admin.AdminViews.Mercedes.MainMercActivity;
import com.example.myautocare.R;

public class AdminHome extends AppCompatActivity {
    TextView Admin_email;
    ImageView BMW,Mercedes,RangeRover,Toyota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Admin_email = findViewById(R.id.admin_email);

        BMW = findViewById(R.id.imagebmw);
        Mercedes = findViewById(R.id.imagemerce);
        RangeRover = findViewById(R.id.imageRange);
        Toyota = findViewById(R.id.imagetoyota);


        BMW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent BMWedit = new Intent(AdminHome.this, Main2Activity.class);
                startActivity(BMWedit);
            }
        });

        Mercedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mercedit = new Intent(AdminHome.this, MainMercActivity.class);
                startActivity(Mercedit);
            }
        });



    }




}
