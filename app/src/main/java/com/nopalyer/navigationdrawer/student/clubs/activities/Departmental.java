package com.nopalyer.navigationdrawer.student.clubs.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.clubs.adapters.ItemCardViewAdapter;
import com.nopalyer.navigationdrawer.student.clubs.models.DClubs;
import com.nopalyer.navigationdrawer.student.clubs.models.DepClubs;

import java.util.ArrayList;

public class Departmental extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<DClubs> list;

    final String STATE_TITLE = "state_title";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";

    int mode;

    View view;
    Toolbar toolbar;


    public Departmental() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.departmental, container, false);
        setHasOptionsMenu(true);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) getView().findViewById(R.id.text);

        recyclerView = getView().findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.design_default_color_primary)));
        list = new ArrayList<>();
        list.addAll(DepClubs.getListData());
        showRecyclerCardView();


    }

    // menu




    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, "");
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }


        private void showRecyclerCardView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemCardViewAdapter cardViewAdapter = new ItemCardViewAdapter(getActivity());
        cardViewAdapter.setListDClubs(list);
        recyclerView.setAdapter(cardViewAdapter);
    }
}
