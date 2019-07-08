package ua.study.awesome.androidlessons.testtask_skysoft.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import butterknife.BindView;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.alarm_manager.AlarmManagerFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.SignInUpActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserRepository;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserRepositoryImpl;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.BankFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.device_list.DeviceFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.download_upload_retrofit.DownloadFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.gallery.GalleryFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.photo.PhotoFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.rx_search.RxSearchFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.spannable_string.SpannableStringFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class MainActivity extends BaseActivity {

    private SharedPreferences preferences;

    UserRepository model = new UserRepositoryImpl();

    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        navigationItemListen();

        addFragment(BankFragment.getInstance("Privat ATM"), R.id.fragm_container);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    public void startLoginActivity(){
        Intent intent = new Intent(this, SignInUpActivity.class);
        startActivity(intent);
        finish();
    }

    private String getREGISTER_USER_NAME() {
        preferences = getSharedPreferences(AppConstans.PREFERENCE_NAME, MODE_PRIVATE);
        return preferences.getString(AppConstans.REGISTER_USER_NAME, "").trim();
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
                                    replaceFragment(BankFragment.getInstance("Privat ATM"),
                                            BankFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;
                                case R.id.nav_device:
                                    replaceFragment(DeviceFragment.getInstance("Device Search"),
                                            DeviceFragment.FRAGMENT_TEG, R.id.fragm_container);
                                    break;
                                case R.id.nav_spannable:
                                    replaceFragment(SpannableStringFragment.getInstance("Spannsble String"),
                                            SpannableStringFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;
                                case R.id.nav_gallery:
                                    replaceFragment(GalleryFragment.getInstance("Images from gallery"),
                                            GalleryFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;
                                case R.id.nav_photo:
                                    replaceFragment(PhotoFragment.getInstance("Photo"),
                                            PhotoFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;
                                case R.id.nav_retrofit:
                                    replaceFragment(DownloadFragment.getInstance("Downloader images"),
                                            DownloadFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;

                                case R.id.alarm_manager:
                                    replaceFragment(AlarmManagerFragment.getInstance("AlarmBroadcast Manager"),
                                            AlarmManagerFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;

                                case R.id.rx_fragment:
                                    replaceFragment(RxSearchFragment.getInstance("RX Search"),
                                            RxSearchFragment.FRAGMENT_TAG, R.id.fragm_container);
                                    break;

                                case R.id.nav_logout:
                                    model.onRemoveUser(getREGISTER_USER_NAME());
                                    startLoginActivity();
                                    break;
                            }
                        }
                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }
}