package ua.study.awesome.androidlessons.testtask_skysoft.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BankList {

    @SerializedName("devices")
    private ArrayList<Bank> bankList;

    public ArrayList<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(ArrayList<Bank> bankList) {
        this.bankList = bankList;
    }
}
