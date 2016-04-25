package com.gnirt69.FitnessTools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by Stoyan Rizov
 */
public class SignUp extends ActionBarActivity {

    EditText email;
    EditText password;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);



        email = (EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.password);
        Button btnLogin = (Button) findViewById(R.id.btn_Login);


        Firebase.setAndroidContext(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                Firebase ref = new Firebase("https://luminous-heat-7624.firebaseio.com/");
                ref.createUser(email1, password1, new Firebase.ValueResultHandler<Map<String, Object>>() {


                    //ref.createUser("stoyan@firebase.com", "test", new Firebase.ValueResultHandler<Map<String, Object>>() {

                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        //System.out.println("Successfully created user account with uid: " + result.get("uid"));
                        startActivity(new Intent(SignUp.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        // there was an error
                    }
                });
            } });



}



}