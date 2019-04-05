package ua.study.awesome.androidlessons.testtask_skysoft.utils;

import android.util.Log;

public class DifferentSortingArray {

    private static final String TAG = "myLogs";

    void ClickToBubblesSortArray() {

        int[] array = new int[10];
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 999);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {

                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    Log.d(TAG, "Sort array: " + array[0] + " "
                            + array[1] + " " + array[2] + " " + array[3] + " "
                            + array[4] + " " + array[5] + " " + array[6] + " "
                            + array[7] + " " + array[8] + " " + array[9]);
                }
            }
        }
    }

    void ClickToInsertSortArray() {

        int[] array = new int[10];
        int temp, j;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        Log.d(TAG, "Sort array: " + array[0] + " "
                + array[1] + " " + array[2] + " " + array[3] + " "
                + array[4] + " " + array[5] + " " + array[6] + " "
                + array[7] + " " + array[8] + " " + array[9] + " buffer: ");

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = temp;
                j = i;
                while (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;

                Log.d(TAG, "Sort array: " + array[0] + " "
                        + array[1] + " " + array[2] + " " + array[3] + " "
                        + array[4] + " " + array[5] + " " + array[6] + " "
                        + array[7] + " " + array[8] + " " + array[9] + " buffer: " + temp);

            }
        }
    }


}