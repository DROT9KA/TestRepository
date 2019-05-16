package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.data.comparators.DeviceDescriptionComparator;
import ua.study.awesome.androidlessons.testtask_skysoft.data.comparators.DeviceIdComparator;
import ua.study.awesome.androidlessons.testtask_skysoft.data.comparators.DeviceNameComparator;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.DeviceEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ClickListener;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter.DeviceAdapter;

public class DeviceFragment extends BaseFragment {

    public static final String FRAGMENT_TEG = DeviceFragment.class.getSimpleName();

    private DeviceEntity deviceEntityOne;
    private DeviceEntity deviceEntityTwo;
    private DeviceEntity deviceEntityThree;
    private DeviceEntity deviceEntityFour;
    private DeviceEntity deviceEntityFive;
    private DeviceEntity deviceEntitySix;
    private DeviceEntity deviceEntitySeven;
    private DeviceEntity deviceEntityEight;

    private List<DeviceEntity> deviceEntities = null;

    DeviceAdapter adapter;

    @BindView(R.id.recycler_device)
    RecyclerView recyclerDevice;

    @BindView(R.id.edt_search)
    EditText editSearch;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settingDeviceValue();

        settingListDevices();

        adapter = new DeviceAdapter(getContext());
        adapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void onItemClick(int position) {
                DeviceEntity device = adapter.getDevicesFiltered().get(position);

                showDetailFrag(device.getId(), device.getName(), device.getDescription());
            }
        });

        init();

        searchDevice();

    }

    @Override
    public int provideView() {
        return R.layout.fragment_device;
    }

    void init() {
        adapter.setDeviceEntities(deviceEntities);

        recyclerDevice.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerDevice.setAdapter(adapter);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle("Device Search");
    }

    void showDetailFrag(int id, String name, String description) {
        ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragment(DetailDeviceFragment
                .newInstance(id, name, description), DetailBankFragment.FRAGMENT_TAG, R.id.fragm_container);
    }

    public void searchDevice() {

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString(), new Filter.FilterListener() {
                    @Override
                    public void onFilterComplete(int count) {

                        if (adapter.getDevicesFiltered().isEmpty()) {
                            tvEmpty.setVisibility(View.VISIBLE);
                        } else {
                            tvEmpty.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.sort_menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_by_id:
                sortById();
                break;
            case R.id.sort_by_name:
                sortByName();
                break;
            case R.id.sort_by_description:
                sortByDescription();
                break;
            case android.R.id.home:
                ((MainActivity) Objects.requireNonNull(getActivity())).drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sortById() {
//        adapter.removeDevices();
        settingListDevices();
        Collections.sort(deviceEntities, new DeviceIdComparator());
        adapter.setDeviceEntities(deviceEntities);
        recyclerDevice.setAdapter(adapter);
    }

    public void sortByName() {
//        adapter.removeDevices();
        settingListDevices();
        Collections.sort(deviceEntities, new DeviceNameComparator());
        adapter.setDeviceEntities(deviceEntities);
        recyclerDevice.setAdapter(adapter);
    }

    public void sortByDescription() {
//        adapter.removeDevices();
        settingListDevices();
        Collections.sort(deviceEntities, new DeviceDescriptionComparator());
        adapter.setDeviceEntities(deviceEntities);
        recyclerDevice.setAdapter(adapter);
    }

    public void settingDeviceValue() {
        deviceEntities = new ArrayList<>();
        deviceEntityOne = new DeviceEntity(11111111, "Xiaomi", getString(R.string.xiaomi_description));
        deviceEntityTwo = new DeviceEntity(22222222, "Samsung", getResources().getString(R.string.samsung_description));
        deviceEntityThree = new DeviceEntity(33333333, "IPhone", getResources().getString(R.string.iphone_description));
        deviceEntityFour = new DeviceEntity(44444444, "Huawei", getResources().getString(R.string.huawei_description));
        deviceEntityFive = new DeviceEntity(55555555, "Nokia", getResources().getString(R.string.nokia_description));
        deviceEntitySix = new DeviceEntity(66666666, "Motorolla", getResources().getString(R.string.motorolla_description));
        deviceEntitySeven = new DeviceEntity(77777777, "Dendi", getResources().getString(R.string.dendi_description));
        deviceEntityEight = new DeviceEntity(88888888, "PlayStation", getResources().getString(R.string.play_station_description));
    }

//    int number = 1000;

    public void settingListDevices() {
        deviceEntities.add(deviceEntityOne);
        deviceEntities.add(deviceEntityTwo);
        deviceEntities.add(deviceEntityThree);
        deviceEntities.add(deviceEntityFour);
        deviceEntities.add(deviceEntityFive);
        deviceEntities.add(deviceEntitySix);
        deviceEntities.add(deviceEntitySeven);
        deviceEntities.add(deviceEntityEight);
//        Random randomaizer = new Random();
//
//        for (int i = 0; i < number; i++) {
//
//            int random = randomaizer.nextInt(6);
//
//            switch (random) {
//                case 1:
//                    deviceEntities.add(deviceEntityOne);
//                    break;
//                case 2:
//                    deviceEntities.add(deviceEntityTwo);
//                    break;
//                case 3:
//                    deviceEntities.add(deviceEntityThree);
//                    break;
//                case 4:
//                    deviceEntities.add(deviceEntityFour);
//                    break;
//                case 5:
//                    deviceEntities.add(deviceEntityFive);
//                    break;
//            }
//        }
    }
}