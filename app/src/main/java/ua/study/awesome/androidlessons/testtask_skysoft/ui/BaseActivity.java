package ua.study.awesome.androidlessons.testtask_skysoft.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        ButterKnife.bind((Activity) butterKnifeBind());

    }

    public abstract Object butterKnifeBind();

    protected abstract int getLayoutResourceId();

    public void replaceFragment(Fragment fragment, String tag, int container) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(container, fragment)
                .addToBackStack(tag)
                .commit();
    }

    public void replaceFragment(Fragment fragment, int container) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(container, fragment)
                .commit();
    }

    public void addFragment(Fragment fragment, String tag, int container){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(container, fragment)
                .addToBackStack(tag)
                .commit();
    }

    public void addFragment(Fragment fragment, int container){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(container, fragment)
                .commit();
    }
}