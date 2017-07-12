package com.example.minhl.viewpage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private static ListView lvSomething;
    private static CustomList list;

    public ListFragment() {
    }

    public static void changeListView(Context context, String fullName) {
        if (fullName != null) {
            list.add(fullName);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_list_item_1, list);

        lvSomething.setAdapter(arrayAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        lvSomething = (ListView) view.findViewById(R.id.lv_something);
        list = CustomList.getInstance();

        lvSomething.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addDetailFragment();
                DetailFragment.changeDetail(list.get(position));
            }
        });
        return view;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        addDetailFragment();
//    }

    private void addDetailFragment() {
        getChildFragmentManager().beginTransaction().replace(R.id.frag_container, new DetailFragment()).commit();
        getChildFragmentManager().executePendingTransactions();
    }
}
