package com.example.myautocare.MenuActivities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myautocare.Activities.MainActivity;
import com.example.myautocare.R;
import com.example.myautocare.User.LoginActivity;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Profile extends AppCompatActivity {

    TextView name1, name2, idn, mail;

    Button changedetails;

    String first_name, last_name, id, email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        changedetails = findViewById(R.id.changedetails);


        try {
            name1 = findViewById(R.id.name1);
            name2 = findViewById(R.id.lastn);
            idn = findViewById(R.id.id);
            mail = findViewById(R.id.mail);


            Intent intent = getIntent();

            first_name = intent.getStringExtra("first_name");
            last_name = intent.getStringExtra("last_name");
            id = intent.getStringExtra("id_number");
            email = intent.getStringExtra("email");
            password = intent.getStringExtra("password");

            name1.setText("First Name: " + first_name);
            name2.setText("Last Name: " + last_name);
            idn.setText("Id Number: " + id);
            mail.setText("Email: " + email);

            Toast.makeText(this, " Welcome " + first_name, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(this, "not working", Toast.LENGTH_SHORT).show();

        }

        changedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Profile.this, Settings.class);
                intent.putExtra("first_name",first_name);
                intent.putExtra("last_name",last_name);
                intent.putExtra("id_number",id);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });

    }
}



