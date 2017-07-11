package com.example.minhl.viewpage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhl on 10/07/2017.
 */

public class ThirdFragment extends Fragment implements Callback {

    private Context context;
    private ListView lvThird;
    private List<String> list = new ArrayList<>();

    public ThirdFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        lvThird = (ListView) view.findViewById(R.id.lv_third);
        return view;
    }

    @Override
    public void sendItem(String fullName) {
        list.add(fullName);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        lvThird.setAdapter(arrayAdapter);
    }
}
