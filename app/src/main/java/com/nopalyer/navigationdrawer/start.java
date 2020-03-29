package com.nopalyer.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.nopalyer.navigationdrawer.chemical.chemical1;
import com.nopalyer.navigationdrawer.civil.Civil;
import com.nopalyer.navigationdrawer.cse.CSE;
import com.nopalyer.navigationdrawer.ece.ece;
import com.nopalyer.navigationdrawer.electrical.ee;
import com.nopalyer.navigationdrawer.material.material;
import com.nopalyer.navigationdrawer.mechanical.me;

public class start extends Fragment {
    View view;
    private CardView cscv,eecv,ab1,ab2,ab3,mecv;

    private CardView ab4;


    public start()  {

  }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.start,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ab1 = (CardView) (getView().findViewById(R.id.ece));
        ab2 = (CardView) (getView().findViewById(R.id.chemical));
        ab3 = (CardView) (getView().findViewById(R.id.material));
        cscv = (CardView) (getView().findViewById(R.id.cscv));
        eecv = (CardView) (getView().findViewById(R.id.eecv));
        mecv = (CardView) (getView().findViewById(R.id.mecv));
        ab4 = (CardView) (getView().findViewById(R.id.civil));
        ab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ece.class));
            }
        });
        ab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), chemical1.class));
            }
        });
        ab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), material.class));
            }
        });
        cscv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CSE.class));

            }
        });

        eecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ee.class));

            }
        });

        mecv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), me.class));

            }
        });
        ab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Civil.class));
            }
        });
    }
}
