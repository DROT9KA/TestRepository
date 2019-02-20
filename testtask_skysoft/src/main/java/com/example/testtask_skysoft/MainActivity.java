package com.example.testtask_skysoft;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.testtask_skysoft.interfaces.PrivatBankAPI;
import com.example.testtask_skysoft.adapter.BankAdapter;
import com.example.testtask_skysoft.models.BankList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerBanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/p24api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PrivatBankAPI privatBankAPI = retrofit.create(PrivatBankAPI.class);

        Call<BankList> call = privatBankAPI.getBanks();
        call.enqueue(new Callback<BankList>() {
            @Override
            public void onResponse(Call<BankList> call, Response<BankList> response) {
                BankList bankList = response.body();
                BankAdapter adapter = new BankAdapter(bankList.getBankList());
                recyclerBanks.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BankList> call, Throwable t) {
                String str = new String();
            }
        });

    }

    public void initRecyclerView(){
        recyclerBanks = findViewById(R.id.recycler_banks);
        recyclerBanks.setLayoutManager(new LinearLayoutManager(this));
    }
}