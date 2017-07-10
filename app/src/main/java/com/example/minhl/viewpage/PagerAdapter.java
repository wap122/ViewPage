package com.example.minhl.viewpage;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by minhl on 10/07/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private IOSFragment iosFragment;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        iosFragment = new IOSFragment(context);
    }

//Muốn giữ View thật ra tạo 1 viewHolder cũng dc :D
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new AndroidFragment(context, iosFragment);
                break;
            case 1:
                frag = iosFragment;
                break;
            case 2:
                frag = new PHPFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Android";
                break;
            case 1:
                title = "IOS";
                break;
            case 2:
                title = "PHP";
                break;
        }

        return title;
    }

}
