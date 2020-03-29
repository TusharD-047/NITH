package com.nopalyer.navigationdrawer.humanities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.nopalyer.navigationdrawer.R;

public class humanities extends Fragment {
    View view;
    public humanities()  {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.humanities_humanities,container,false);
        return view;
    }
    CardView cv1,cv2,cv3,cv4;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cv1 = (CardView) getView().findViewById(R.id.cv1);
        cv2 = (CardView)  getView().findViewById(R.id.cv2);
        cv3 = (CardView)  getView().findViewById(R.id.cv3);
        cv4 = (CardView)  getView().findViewById(R.id.cv4);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),humanitiesaboutus.class);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),humanitiesvision.class);
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), humanitiescourses.class);
                startActivity(intent);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),humanitieslabs.class);
                startActivity(intent);
            }
        });

    }
}
