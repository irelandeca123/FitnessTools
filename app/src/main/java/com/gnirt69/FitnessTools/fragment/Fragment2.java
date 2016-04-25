package com.gnirt69.FitnessTools.fragment; /**
 * Created by asd
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.gnirt69.FitnessTools.LogIn;
import com.gnirt69.FitnessTools.R;
import com.gnirt69.FitnessTools.User;

import java.util.HashMap;
import java.util.Map;

public class Fragment2 extends Fragment{

     EditText benchW;
     EditText squatsW;
     EditText dayW;
    TextView textView;

    public Fragment2 () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        benchW = (EditText)rootView.findViewById(R.id.bench);
        squatsW = (EditText)rootView.findViewById(R.id.squats);
        dayW =(EditText)rootView.findViewById(R.id.day);
        textView = (TextView)rootView.findViewById(R.id.textView);

        Button btnLogin = (Button)rootView.findViewById(R.id.btn_submit);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            final Firebase ref = new Firebase("https://luminous-heat-7624.firebaseio.com/");
            //LogIn test = new LogIn();
            String email4 = LogIn.getEmail();
            String password4 = LogIn.getPassword();


            @Override
            public void onClick(View v) {
                ref.authWithPassword(email4, password4,
                        new Firebase.AuthResultHandler() {
                            @Override
                            public void onAuthenticated(AuthData authData) {

                                String bench = benchW.getText().toString();
                                String squats= squatsW.getText().toString();
                                String day = dayW.getText().toString();


                                User user = new User();
                                user.setBench(bench);
                                ref.child("users").setValue(user);

                                // Authentication just completed successfully :)
                             Map<String, String> map = new HashMap<String, String>();
                               map.put("day", day);
                           //    map.put("benchPress", bench);
                               map.put("squats", squats);
                                //map.put("deadlift", weight1);

                                //      if(authData.getProviderData().containsKey("displayName")) {
                                //          map.put("displayName", authData.getProviderData().get("displayName").toString());
                                //       }
                                ref.child("users").child(authData.getUid()).setValue(map);

                            }

                            @Override
                            public void onAuthenticationError(FirebaseError error) {
                                // Something went wrong :(
                            }
                        });








                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            //Getting the data from snapshot
                            User user = postSnapshot.getValue(User.class);

                            //Adding it to a string
                            String string = "benchPress: " + user.getBench() + "\n\n";

                            //Displaying it on textview
                            textView.setText(string);
                        }

                    //    String title = (String) snapshot.child("users").getValue();

                            //Adding it to a string
                    //        String string = "day: " + user.getDay();

                            //Displaying it on textview
                    //       textView.setText(title);


                        //String string = "Day: "+test.map()+"\nBench: "+test.getAddress()+"\n\n";
                       // textView.setText(string);

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });
            }
        });

        return rootView;
    }

}
