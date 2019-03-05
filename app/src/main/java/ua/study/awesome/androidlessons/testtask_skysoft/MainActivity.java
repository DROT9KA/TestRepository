package ua.study.awesome.androidlessons.testtask_skysoft;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.study.awesome.androidlessons.testtask_skysoft.fragments.FragmentBank;

public class MainActivity extends AppCompatActivity {

    @Nullable @BindView(R.id.toolbar)
    Toolbar toolbar;


    FragmentBank fragmentBank;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        fragmentBank = new FragmentBank();
        fragmInContainer();

//        getSupportActionBar().setTitle("Title");
    }

    public void fragmInContainer(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.fragm_container, fragmentBank);
        fragmentTransaction.commit();
    }
}