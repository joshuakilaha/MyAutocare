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

  TextView name1, name2,idn,mail;

  Button get;

    String first_name,last_name,id,email;


    JSONObject json_data;
    HttpURLConnection con;
    String query, results;
    ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



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

            name1.setText("First Name: "+ first_name);
            name2.setText("Last Name: "+last_name);
            idn.setText("Id Number: "+id);
            mail.setText("Email: "+ email);

            Toast.makeText(this, " Welcome " + first_name, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(this, "not working", Toast.LENGTH_SHORT).show();

        }

    }

   /*
    final class Login extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Profile.this);
            mProgressDialog.setMessage("Logging in, please wait...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }
        @Override
        protected Void doInBackground(String... params) {
            try {
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("email", email.getText().toString().trim())
                        .appendQueryParameter("password", password.getText().toString().trim())
                        .appendQueryParameter("first_name", firstn.getText().toString().trim())
                        .appendQueryParameter("last_name",lastn.getText().toString().trim());


                query = builder.build().getEncodedQuery();
                String url = "https://beastly-defection.000webhostapp.com/AutoCare/profile.php";

                URL obj = new URL(url);
                con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0;Windows NT 5.1)");
                con.setRequestProperty("Accept-Language", "UTF-8");
                con.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new
                        OutputStreamWriter(con.getOutputStream());
                outputStreamWriter.write(query);
                outputStreamWriter.flush();
            } catch (Exception e) {
                android.util.Log.e("Fail 1", e.toString());
            }
            try {
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(con.getInputStream()));
                String line;
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line + "\n");
                }
                results = sb.toString();
            } catch (Exception e) {
                android.util.Log.e("Fail 2", e.toString());
            }
            return null;

        }
        @Override
        protected void onPostExecute(Void result) {
            try {
                json_data = new JSONObject(results);
                int code = (json_data.getInt("code"));
                if (code == 1) {


                    firstn.setText(json_data.getString("first_name"));
                    lastn.setText(json_data.getString("last_name"));

                } else {


                    final AlertDialog.Builder alert = new
                            AlertDialog.Builder(Profile.this);
                    alert.setTitle("Failed");
                    alert.setMessage(" Failed to log in ");
                    alert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(@NonNull DialogInterface dialog, int whichButton)
                        {
                            dialog.cancel();
                        }
                    });
                    alert.show();
                }
            } catch (Exception e) {
                Log.e("Fail 3", e.toString());
            }
            mProgressDialog.dismiss();
        }
    }

*/

}

