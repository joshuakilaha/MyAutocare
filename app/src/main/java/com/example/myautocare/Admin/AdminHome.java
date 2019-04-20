package com.example.myautocare.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myautocare.Admin.AdminViews.BMW.BMWEdit;
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
                Intent BMWeditactivity = new Intent(AdminHome.this, BMWEdit.class);
                startActivity(BMWeditactivity);
            }
        });



    }




}
