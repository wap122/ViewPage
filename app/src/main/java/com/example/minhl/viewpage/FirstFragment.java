package com.example.minhl.viewpage;

import android.app.*;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    private static final String EMPTY_LIST = "Xóa list rồi còn đâu :(";

    private Context context;
    private EditText edtFirstName, edtLastName;
    private MyTopic myTopic;
    private String fullName;

    public FirstFragment(Context context, MyTopic myTopic) {
        this.myTopic = myTopic;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button btnAddItem = (Button) view.findViewById(R.id.btn_add_item);
        Button btnClearList = (Button) view.findViewById(R.id.btn_clear_list);
        edtFirstName = (EditText) view.findViewById(R.id.edt_fist_name);
        edtLastName = (EditText) view.findViewById(R.id.edt_last_name);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = getFullName();
                if (isEmpty(fullName)) return;
                ListFragment.changeListView(context, fullName);
//                myTopic.sendItem(fullName);
            }
        });

        btnClearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomList.getInstance().clear();
                ListFragment.changeListView(context, null);
                DetailFragment.changeDetail(EMPTY_LIST);
            }
        });

        return view;
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