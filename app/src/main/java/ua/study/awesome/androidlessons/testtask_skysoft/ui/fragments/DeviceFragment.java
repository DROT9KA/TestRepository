package ua.study.awesome.androidlessons.testtask_skysoft.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.comparators.DeviceDescriptionComparator;
import ua.study.awesome.androidlessons.testtask_skysoft.comparators.DeviceIdComparator;
import ua.study.awesome.androidlessons.testtask_skysoft.comparators.DeviceNameComparator;
import ua.study.awesome.androidlessons.testtask_skysoft.data.entity.Device;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.adapter.SearchableAdapter;

public class DeviceFragment extends Fragment {

    private static final String TAG = "myLogs";

    private Device deviceOne;
    private Device deviceTwo;
    private Device deviceThree;
    private Device deviceFour;
    private Device deviceFive;

    private ArrayList<Device> devices = new ArrayList<>();

    SearchableAdapter searchableAdapter;

    @BindView(R.id.recycler_device)
    RecyclerView recyclerDevice;

    @BindView(R.id.edt_search)
    EditText editSearch;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_device, container, false);

        Unbinder unbinder = ButterKnife.bind(this, v);

        setHasOptionsMenu(true);

        settingDeviceValue();

        settingListDevices();

        init();

        searchDevice();

        return v;
    }

    private void init() {
        searchableAdapter = new SearchableAdapter(getContext(), devices);

        recyclerDevice.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerDevice.setAdapter(searchableAdapter);
    }

    public void searchDevice(){

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchableAdapter.getFilter().filter(s.toString(), new Filter.FilterListener() {
                    @Override
                    public void onFilterComplete(int count) {

                        searchableAdapter.setDevices(searchableAdapter.getDevices());

                        if (searchableAdapter.getDevices().isEmpty()){
                            tvEmpty.setVisibility(View.VISIBLE);
                        }else {
                            tvEmpty.setVisibility(View.INVISIBLE);
                        }
                    }
                });
//                filter(s.toString());
            }
        });
    }

//    public void filter(String text){
//        ArrayList<Device> filteredList = new ArrayList<>();
//
//        for (Device device: devices){
//            if(device.getName().toLowerCase().contains(text.toLowerCase())){
//                filteredList.add(device);
//            }
//        }
//
//        if (filteredList.isEmpty()){
//            tvEmpty.setVisibility(View.VISIBLE);
//        } else {
//            tvEmpty.setVisibility(View.INVISIBLE);
//        }
//
//        adapter.filterList(filteredList);
//    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.sort_menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
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

    public void sortById(){
        searchableAdapter.removeDevices();
        settingListDevices();
        Collections.sort(devices, new DeviceIdComparator());
        searchableAdapter.setDevices(devices);
        recyclerDevice.setAdapter(searchableAdapter);
    }

    public void sortByName(){
        searchableAdapter.removeDevices();
        settingListDevices();
        Collections.sort(devices, new DeviceNameComparator());
        searchableAdapter.setDevices(devices);
        recyclerDevice.setAdapter(searchableAdapter);
    }

    public void sortByDescription(){
        searchableAdapter.removeDevices();
        settingListDevices();
        Collections.sort(devices, new DeviceDescriptionComparator());
        searchableAdapter.setDevices(devices);
        recyclerDevice.setAdapter(searchableAdapter);
    }

    public void settingDeviceValue() {
        deviceOne = new Device(11111111, "Xiaomi", getString(R.string.xiaomi_description));
        deviceTwo = new Device(22222222, "Samsung", getResources().getString(R.string.samsung_description));
        deviceThree = new Device(33333333, "IPhone", getResources().getString(R.string.iphone_description));
        deviceFour = new Device(44444444, "Huawei", getResources().getString(R.string.huawei_description));
        deviceFive = new Device(55555555, "Nokia", getResources().getString(R.string.nokia_description));
    }

    int number = 1000;
    public void settingListDevices() {
        Random randomaizer = new Random();

        for (int i = 0; i < number; i++) {

            int random = randomaizer.nextInt(6);

            switch (random) {
                case 1:
                    devices.add(deviceOne);
                    break;
                case 2:
                    devices.add(deviceTwo);
                    break;
                case 3:
                    devices.add(deviceThree);
                    break;
                case 4:
                    devices.add(deviceFour);
                    break;
                case 5:
                    devices.add(deviceFive);
                    break;
            }
        }
    }
}