package com.gnirt69.FitnessTools.fragment;/**
 * Created by NgocTri on 10/18/2015.
 */

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gnirt69.FitnessTools.LogIn;
import com.gnirt69.FitnessTools.R;

public class Fragment3 extends Fragment{

    public Fragment3() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment3, container, false);

        Intent intent = new Intent(getActivity(),LogIn.class);
     //  Fragment3.this.startActivity(intent);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        return rootView;
    }


}