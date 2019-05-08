package ua.study.awesome.androidlessons.testtask_skysoft.ui;

import android.Manifest;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.DetailDeviceFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.DeviceFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.ImageFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.SpannableStringFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        navigationItemListen();

//        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, );

        addFragment(BankImpl.newInstance("Privat ATM"));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    public void navigationItemListen() {
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        if (menuItem.isChecked()) {
                            menuItem.setChecked(false);
                        } else {
                            menuItem.setChecked(true);

                            switch (menuItem.getItemId()) {
                                case R.id.nav_bank:
                                    replaceFragment(BankImpl.newInstance("Privat ATM"), BankImpl.FRAGMENT_TAG);
                                    break;
                                case R.id.nav_device:
                                    replaceFragment(new DeviceFragment(), DeviceFragment.FRAGMENT_TEG);
                                    break;
                                case R.id.nav_spannable:
                                    replaceFragment(new SpannableStringFragment(), SpannableStringFragment.FRAGMENT_TAG);
                                    break;
                                case R.id.nav_image:
                                    replaceFragment(new ImageFragment(), ImageFragment.FRAGMENT_TAG);
                                    break;
                                case R.id.nav_logout:
                                    finish();
                                    break;
                            }
                        }
                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }
}