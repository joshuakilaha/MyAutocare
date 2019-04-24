package com.example.myautocare.MenuActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myautocare.R;
import com.example.myautocare.User.User;

public class ContactUs extends AppCompatActivity {

    String first_name;
    TextView  name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        name = findViewById(R.id.name);

        try {
            Intent intent = getIntent();
            first_name = intent.getStringExtra("first_name");

            setTitle(first_name);
            name.setText(first_name);

            Toast.makeText(this, " Welcome " + first_name, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){

            Toast.makeText(this, "not working", Toast.LENGTH_SHORT).show();

        }
    }



}
