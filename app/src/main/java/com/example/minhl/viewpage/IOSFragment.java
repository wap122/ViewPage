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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class IOSFragment extends Fragment implements Callback {

    private TextView tvName;
    private Context context;
    private ListView lvIos;
    private List<String> list = new ArrayList<>();

    public IOSFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ios, container, false);
        lvIos = (ListView) view.findViewById(R.id.lv_ios);
        return view;
    }

    @Override
    public void sendItem(String fullName) {
        list.add(fullName);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        lvIos.setAdapter(arrayAdapter);
    }
}
