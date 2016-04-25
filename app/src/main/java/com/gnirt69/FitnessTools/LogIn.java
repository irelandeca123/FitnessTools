package com.gnirt69.FitnessTools;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by Stoyan Rizov
 */
public class LogIn extends ActionBarActivity
{
   public EditText email;
   public EditText password;
    private static String email4;
    private static  String password4;

    public void redirect (View view) {

        startActivity(new Intent(LogIn.this, SignUp.class));
    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);

        Firebase.setAndroidContext(this);

        email = (EditText) findViewById(R.id.loginemail);
        password= (EditText) findViewById(R.id.loginpassword);
        Button btnLogin = (Button) findViewById(R.id.btn_Login1);






        WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);






        btnLogin.setOnClickListener(new View.OnClickListener() {

            Firebase ref = new Firebase("https://luminous-heat-7624.firebaseio.com/");



            @Override
            public void onClick(View v) {
        Firebase.AuthResultHandler authResultHandler = new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {

                startActivity(new Intent(LogIn.this, MainActivity.class));
                finish();
                // Authenticated successfully with payload authData
            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // Authenticated failed with error firebaseError
                Toast.makeText(getApplicationContext(), "Wrong Details!", Toast.LENGTH_LONG).show();

            }
        };
                 email4 = email.getText().toString();
                 password4 = password.getText().toString();

                ref.authWithPassword(email4, password4, authResultHandler);




/*
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Long timestamp = (Long) snapshot.getValue();
                        System.out.println(timestamp);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

                ref.setValue(ServerValue.TIMESTAMP);

*/



            }



        });

    }



    public static void setEmail(String em){
        email4 = em;
    }

    public static void setPassword(String pass){
        password4 = pass;
    }

    public static String getEmail(){
        return email4;
    }
    public static String getPassword(){
        return password4;
    }


}
