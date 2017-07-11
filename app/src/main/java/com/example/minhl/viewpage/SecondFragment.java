package com.example.minhl.viewpage;

/**
 * Created by minhl on 10/07/2017.
 */

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

public class SecondFragment extends Fragment implements Callback {

    private Context context;
    private ListView lvSecond;
    private List<String> list = new ArrayList<>();

    public SecondFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        lvSecond = (ListView) view.findViewById(R.id.lv_second);
        return view;
    }

    @Override
    public void sendItem(String fullName) {
        list.add(fullName);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        lvSecond.setAdapter(arrayAdapter);
    }
}
