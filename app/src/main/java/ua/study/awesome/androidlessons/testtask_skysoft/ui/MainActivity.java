package ua.study.awesome.androidlessons.testtask_skysoft.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.DeviceFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.SpannableStringFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;

    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        navigationItemListen();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragm_container, BankFragment.newInstance("Privat ATM"));
        fragmentTransaction.commit();
    }

    public void navigationItemListen() {
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        if (menuItem.isChecked()){
                            menuItem.setChecked(false);
                        } else {
                            menuItem.setChecked(true);

                            switch (menuItem.getItemId()) {
                                case R.id.nav_bank:
                                    bankFragmInContainer();
                                    break;
                                case R.id.nav_device:
                                    deviceFragmInContainer();
                                    break;
                                case R.id.nav_spannable:
                                    spannableFragmInContainer();
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


    public void bankFragmInContainer() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragm_container, BankFragment.newInstance("Privat ATM"));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void deviceFragmInContainer() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragm_container, new DeviceFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void spannableFragmInContainer() {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragm_container, new SpannableStringFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}