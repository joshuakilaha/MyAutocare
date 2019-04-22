package com.example.myautocare.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myautocare.MenuActivities.AboutUs;
import com.example.myautocare.MenuActivities.Brands;
import com.example.myautocare.MenuActivities.ContactUs;
import com.example.myautocare.MenuActivities.MyParts;
import com.example.myautocare.MenuActivities.Mylocation;
import com.example.myautocare.MenuActivities.Profile;
import com.example.myautocare.MenuActivities.Settings;
import com.example.myautocare.R;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView mNavigationView;

    /////webview////
    WebView webView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        progressBar = findViewById(R.id.progress_barweb);

       webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.carmagazine.co.uk/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                setTitle("Loading...");
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());
                super.onPageFinished(view, url);
            }
        });



        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigationView = findViewById(R.id.design_navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

    }

    ////webview backpressed


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        else {

            super.onBackPressed();
        }

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
                Intent profile = new Intent(MainActivity.this, Profile.class);
                startActivity(profile);

                Toast.makeText(MainActivity.this, "Profile opened", Toast.LENGTH_SHORT).show();
                break;

            case R.id.brands:
                Intent brands = new Intent(MainActivity.this, Brands.class);
                startActivity(brands);
                Toast.makeText(MainActivity.this, "Brands opened", Toast.LENGTH_SHORT).show();
                break;

            case R.id.myparts:
                Intent myparts = new Intent(MainActivity.this, MyParts.class);
                startActivity(myparts);
                Toast.makeText(MainActivity.this, "My Parts opened..", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mylocation:
                Intent mylocation = new Intent(MainActivity.this, Mylocation.class);
                startActivity(mylocation);
                Toast.makeText(MainActivity.this, "Map has opened..", Toast.LENGTH_SHORT).show();
                break;

            case R.id.aboutus:
                Intent aboutus = new Intent(MainActivity.this, AboutUs.class);
                startActivity(aboutus);
                Toast.makeText(MainActivity.this, "About Us opened...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                Intent settings = new Intent(MainActivity.this, Settings.class);
                startActivity(settings);
                Toast.makeText(MainActivity.this, "settings opened...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contactus:
                Intent contactus = new Intent(MainActivity.this, ContactUs.class);
                startActivity(contactus);
                Toast.makeText(MainActivity.this, "Contact Us opened...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:

                Toast.makeText(MainActivity.this, "Logging out...", Toast.LENGTH_SHORT).show();
                break;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }
}
