package ua.study.awesome.androidlessons.testtask_skysoft.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import butterknife.BindView;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.BankFragmentImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.DeviceFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.ImageFragmentImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.PhotoFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments.SpannableStringFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationItemListen();

        addFragment(BankFragmentImpl.newInstance("Privat ATM"), R.id.fragm_container);
    }

    @Override
    public Object butterKnifeBind() {
        return this;
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
                                    replaceFragment(BankFragmentImpl.newInstance("Privat ATM"),
                                            BankFragmentImpl.FRAGMENT_TAG, R.id.fragm_container);
                                    break;
                                case R.id.nav_device:
                                    replaceFragment(new DeviceFragment(),
                                            DeviceFragment.FRAGMENT_TEG, R.id.fragm_container);
                                    break;
                                case R.id.nav_spannable:
                                    replaceFragment(new SpannableStringFragment(),
                                            SpannableStringFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;
                                case R.id.nav_image:
                                    replaceFragment(new ImageFragmentImpl(),
                                            ImageFragmentImpl.FRAGMENT_TAG, R.id.fragm_container);
                                    break;
                                case R.id.nav_photo:
                                    replaceFragment(new PhotoFragment(),
                                            PhotoFragment.FRAGMENT_TAG, R.id.fragm_container);
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