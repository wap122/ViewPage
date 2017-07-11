package com.example.minhl.viewpage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private static DetailFragment detailFragment;

    private static TextView tvDetail;

//    public static synchronized DetailFragment getInstance() {
//        if (detailFragment == null) {
//            detailFragment = new DetailFragment();
//        }
//        return detailFragment;
//    }

    public DetailFragment() {
    }

    public static void changeDetail(String detail) {
        tvDetail.setText(detail);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tvDetail = (TextView) view.findViewById(R.id.tv_detail);
        return view;
    }
}
