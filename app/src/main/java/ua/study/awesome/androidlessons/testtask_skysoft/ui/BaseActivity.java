package ua.study.awesome.androidlessons.testtask_skysoft.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ua.study.awesome.androidlessons.testtask_skysoft.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

    }
    protected abstract int getLayoutResourceId();

    public void replaceFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragm_container, fragment)
                .addToBackStack(tag)
                .commit();
    }

    public void addFragment(Fragment fragment, String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragm_container, fragment)
                .addToBackStack(tag)
                .commit();
    }

    public void addFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragm_container, fragment)
                .commit();
    }
}