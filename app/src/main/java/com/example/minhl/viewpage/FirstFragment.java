package com.example.minhl.viewpage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by minhl on 10/07/2017.
 */

public class FirstFragment extends Fragment {

    private Context context;
    private ListView lvAndroid;
    private EditText edtFirstName;
    private EditText edtLastName;
    private List<String> list;
    private List<Callback> listCallback;
    private String fullName;

    public FirstFragment(Context context, List<Callback> listTemp) {
        this.listCallback = listTemp;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        lvAndroid = (ListView) view.findViewById(R.id.lv_android);
        Button btnAddItem = (Button) view.findViewById(R.id.btn_additem);
        edtFirstName = (EditText) view.findViewById(R.id.edt_fist_name);
        edtLastName = (EditText) view.findViewById(R.id.edt_last_name);

        list = new ArrayList<>();

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = getFullName();
                if (isEmpty(fullName)) return;
                list.add(fullName);
                applyChangeToListView();
                for (Callback E : listCallback) {
                    E.sendItem(fullName);
                }
            }
        });

        return view;
    }

    private void applyChangeToListView() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        lvAndroid.setAdapter(arrayAdapter);
    }

    private String getFullName() {
        String firstName = edtFirstName.getText().toString();
        String lastName = edtLastName.getText().toString();
        return firstName + " " + lastName;
    }

    private boolean isEmpty(String fullName) {
        return Objects.equals(fullName, " ");
    }
}