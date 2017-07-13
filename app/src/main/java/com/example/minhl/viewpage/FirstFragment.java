package com.example.minhl.viewpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

/**
 * Created by minhl on 10/07/2017.
 */

public class FirstFragment extends Fragment {

    private static final String EMPTY_LIST = "Xóa list rồi còn đâu :(";
    public FragmentTransaction fragmentTransaction;
    private EditText edtFirstName, edtLastName;
    private MyTopic myTopic;
    private String fullName;
    private ListFragment listFragment;

    public FirstFragment(MyTopic myTopic) {
        this.myTopic = myTopic;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button btnAddItem = (Button) view.findViewById(R.id.btn_add_item);
        Button btnClearList = (Button) view.findViewById(R.id.btn_clear_list);
        edtFirstName = (EditText) view.findViewById(R.id.edt_fist_name);
        edtLastName = (EditText) view.findViewById(R.id.edt_last_name);
        listFragment = ListFragment.getInstance();
        getChildFragmentManager().beginTransaction().replace(R.id.ll_container,
                listFragment).commit();

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = getFullName();
                if (isEmpty(fullName)) return;
                listFragment.changeListView(fullName);
//                myTopic.sendItem(fullName);
            }
        });

        btnClearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listFragment.list.clear();
                listFragment.changeListView(null);
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