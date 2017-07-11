package com.example.minhl.viewpage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ForthFragment extends Fragment implements Callback {

    private Context context;
    private ListView lvForth;
    private List<String> list = new ArrayList<>();

    public ForthFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forth, container, false);
        lvForth = (ListView) view.findViewById(R.id.lv_forth);
        return view;
    }

    @Override
    public void sendItem(String fullName) {
        list.add(fullName);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        lvForth.setAdapter(arrayAdapter);
    }
}
