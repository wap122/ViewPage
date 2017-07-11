package com.example.minhl.viewpage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FifthFragment extends Fragment implements Observer {

    private Context context;
    private ListView lvFifth;
    private List<String> list = new ArrayList<>();

    public FifthFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fifth, container, false);
        lvFifth = (ListView) view.findViewById(R.id.lv_fifth);
        return view;
    }

    @Override
    public void update(String fullName) {
        list.add(fullName);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        lvFifth.setAdapter(arrayAdapter);
    }

}
