package com.example.minhl.viewpage;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minhl on 11/07/2017.
 */

public class CustomList extends ArrayList<String> {
    private static CustomList customInstance;

    private CustomList() {
    }

    public static synchronized CustomList getInstance() {
        if (customInstance == null) {
            customInstance = new CustomList();
        }
        return customInstance;

    }
}
