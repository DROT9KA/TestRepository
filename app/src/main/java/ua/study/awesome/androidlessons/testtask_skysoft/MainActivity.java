package ua.study.awesome.androidlessons.testtask_skysoft;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    private RecyclerView recyclerBanks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initRecyclerView();

//        PrivatBankAPI privatBankAPI = MainRetrofit.getInstance().getRetrofit().create(PrivatBankAPI.class);
//
//        Call<BankList> call = privatBankAPI.getBanks();
//        call.enqueue(new Callback<BankList>() {
//            @Override
//            public void onResponse(Call<BankList> call, Response<BankList> response) {
//                BankList bankList = response.body();
//                BankAdapter adapter = new BankAdapter(MainActivity.this);
//                adapter.setBanks(bankList.getBankList());
//                recyclerBanks.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<BankList> call, Throwable t) {
//                String str = new String();
//            }
//        });

    }

//    public void initRecyclerView(){
//        recyclerBanks = findViewById(R.id.recycler_banks);
//        recyclerBanks.setLayoutManager(new LinearLayoutManager(this));
//    }
}