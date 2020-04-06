package com.nopalyer.navigationdrawer.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nopalyer.navigationdrawer.R;

public class science extends Fragment {

    public Button btn_chem,btn_msc,btn_hum,btn_manage,btn_archi,btn_phy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_science, null);


    }

    @Override
            public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);


       Button btn_chem= getView().findViewById(R.id.btn_chem);
        Button btn_msc= getView().findViewById(R.id.btn_msc);
        Button btn_hum= getView().findViewById(R.id.btn_hum);
        Button btn_manage= getView().findViewById(R.id.btn_manage);
        Button btn_archi= getView().findViewById(R.id.btn_archi);
        Button btn_phy= getView().findViewById(R.id.btn_phy);

        btn_chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chem_1.class);
                startActivity(intent);
            }
        });
        btn_msc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),msc_1.class);
                startActivity(intent);
            }
        });
        btn_hum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),humanity_1.class);
                startActivity(intent);
            }
        });
        btn_phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),physics_1.class);
                startActivity(intent);
            }
        });
        btn_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),management_1.class);
                startActivity(intent);
            }
        });
        btn_archi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),archi_1.class);
                startActivity(intent);
            }
        });
}}
