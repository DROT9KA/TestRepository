package ua.study.awesome.androidlessons.testtask_skysoft.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

public class SpannableUtils {

    public static SpannableString createSpan(String name, String charString){

        SpannableString spannableString = new SpannableString(name);

        int start = name.toLowerCase().indexOf(charString);
        int end = start + charString.length();

        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

     return spannableString;
    }
}