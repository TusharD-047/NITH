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
import com.nopalyer.navigationdrawer.student.clubs.adapters.ItemCardViewAdapter1;
import com.nopalyer.navigationdrawer.student.clubs.models.TClubs;
import com.nopalyer.navigationdrawer.student.clubs.models.TechClubs;

import java.util.ArrayList;

public class Technical extends Fragment {

    private RecyclerView recyclerView1;
    private ArrayList<TClubs> list;

    final String STATE_TITLE = "state_title";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";

    int mode;

    View view;
    Toolbar toolbar1;
    public Technical()  {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.technical,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) getView().findViewById(R.id.text);


        recyclerView1 = getView().findViewById(R.id.recycler_view1);
        recyclerView1.setHasFixedSize(true);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.design_default_color_primary)));
        list = new ArrayList<>();
        list.addAll(TechClubs.getListData());
        showRecyclerCardView();

}



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, "");
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }


    private void showRecyclerCardView() {
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemCardViewAdapter1 cardViewAdapter = new ItemCardViewAdapter1(getActivity());
        cardViewAdapter.setListTClubs(list);
        recyclerView1.setAdapter(cardViewAdapter);
    }
}
