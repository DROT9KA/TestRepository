package ua.study.awesome.androidlessons.testtask_skysoft.utils;

import android.util.Log;

import java.util.ArrayList;

public class DifferentSortingList {

    private static final String TAG = "myLogs";

    void ClickToBubblesSortList() {

        ArrayList<Integer> list = new ArrayList<>();
        int temp = 0;

        for (int i = 0; i < (10 + (int) (Math.random() * 15)); i++) {
            list.add((int) (Math.random() * 999));
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < (list.size() - i); j++) {
                if (list.get(j - 1) > list.get(j)) {
                    temp = list.get(j - 1);
                    list.set((j - 1), list.get(j));
                    list.set(j, temp);
                    Log.d(TAG, "Sort list: " + list);
                }
            }
        }
    }

    void ClickToInsertSortList() {

        ArrayList<Integer> list = new ArrayList<>();
        int temp, j;

        for (int i = 0; i < (10 + (int) (Math.random() * 15)); i++) {
            list.add((int) (Math.random() * 100));
        }

        Log.d(TAG, "Sort array: " + list + " buffer: ");

        for (int i = 0; i < (list.size() - 1); i++) {
            if (list.get(i) > list.get(i + 1)) {
                temp = list.get(i + 1);
                list.set((i + 1), list.get(i));
                list.set(i, temp);
                j = i;
                while (j > 0 && temp < list.get(j - 1)) {

                    list.set(j, list.get(j - 1));
                    j--;
                }
                list.set(j, temp);

                Log.d(TAG, "Sort list: " + list + " buffer: " + temp);
            }
        }
    }


}