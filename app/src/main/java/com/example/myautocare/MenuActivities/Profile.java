package com.example.myautocare.MenuActivities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myautocare.R;

public class Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mDrawerLayout = findViewById(R.id.drawer_layout);


            mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
            mDrawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            mNavigationView = findViewById(R.id.design_navigation_view);
            mNavigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.profile:
                Intent profile = new Intent(Profile.this, Profile.class);
                startActivity(profile);

                Toast.makeText(Profile.this, "Profile opened", Toast.LENGTH_SHORT).show();
                break;

            case R.id.brands:
                Intent brands = new Intent(Profile.this, Brands.class);
                startActivity(brands);
                Toast.makeText(Profile.this, "Brands opened", Toast.LENGTH_SHORT).show();
                break;

            case R.id.myparts:
                Intent myparts = new Intent(Profile.this, MyParts.class);
                startActivity(myparts);
                Toast.makeText(Profile.this, "My Parts opened..", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mylocation:
                Intent mylocation = new Intent(Profile.this, Mylocation.class);
                startActivity(mylocation);
                Toast.makeText(Profile.this, "Map has opened..", Toast.LENGTH_SHORT).show();
                break;

            case R.id.aboutus:
                Intent aboutus = new Intent(Profile.this, AboutUs.class);
                startActivity(aboutus);
                Toast.makeText(Profile.this, "About Us opened...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                Intent settings = new Intent(Profile.this, Settings.class);
                startActivity(settings);
                Toast.makeText(Profile.this, "settings opened...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contactus:
                Intent contactus = new Intent(Profile.this, ContactUs.class);
                startActivity(contactus);
                Toast.makeText(Profile.this, "Contact Us opened...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:

                Toast.makeText(Profile.this, "Logging out...", Toast.LENGTH_SHORT).show();
                break;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }
}

