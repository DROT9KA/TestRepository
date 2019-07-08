package com.example.myapplication.qweqweqwe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    int PAGE_COUNT = 4;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initViewPager(){
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return PagerFragment.newInstance(i);
            }

            @Override
            public int getCount() {
                return PAGE_COUNT;
            }
        };
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new CircularViewPagerHandler(viewPager));
    }

}