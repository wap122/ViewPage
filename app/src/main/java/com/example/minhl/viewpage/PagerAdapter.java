package com.example.minhl.viewpage;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhl on 10/07/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUMBER_FRAGMENT = 5;
    private MyTopic myTopic;
    private Context context;


    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        myTopic = new MyTopic();

        myTopic.register(new SecondFragment(context));
        myTopic.register(new ThirdFragment(context));
        myTopic.register(new ForthFragment(context));
        myTopic.register(new FifthFragment(context));


    }

//Muốn giữ View thật ra tạo 1 viewHolder cũng dc :D
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new FirstFragment(context, myTopic);
                break;
            case 1:
                frag = (Fragment) myTopic.observers.get(0);
                break;
            case 2:
                frag = (Fragment) myTopic.observers.get(1);
                break;
            case 3:
                frag = (Fragment) myTopic.observers.get(2);
                break;
            case 4:
                frag = (Fragment) myTopic.observers.get(3);
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return NUMBER_FRAGMENT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "First";
                break;
            case 1:
                title = "Second";
                break;
            case 2:
                title = "Third";
                break;
            case 3:
                title = "Forth";
                break;
            case 4:
                title = "Fifth";
                break;
        }

        return title;
    }

}
