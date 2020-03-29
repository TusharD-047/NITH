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

import com.nopalyer.navigationdrawer.chemistry.chemistry;
import com.nopalyer.navigationdrawer.math.maths;
import com.nopalyer.navigationdrawer.physics.Physics;

public class sciences extends Fragment {
    View view;
    CardView ab5,ab6,ab7;

    public sciences() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.science,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ab5 = (CardView)(getView().findViewById(R.id.chemistry));
        ab6 = (CardView)(getView().findViewById(R.id.physics));
        ab7 = (CardView)(getView().findViewById(R.id.maths));

        ab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), chemistry.class));
            }
        });
        ab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Physics.class));
            }
        });
        ab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), maths.class));
            }
        });

    }
}
