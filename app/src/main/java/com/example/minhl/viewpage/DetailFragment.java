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

    private TextView tvDetail;
    private String detail;

    public DetailFragment(String detail) {
        this.detail = detail;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tvDetail = (TextView) view.findViewById(R.id.tv_detail);
        tvDetail.setText(detail);
        return view;
    }
}
