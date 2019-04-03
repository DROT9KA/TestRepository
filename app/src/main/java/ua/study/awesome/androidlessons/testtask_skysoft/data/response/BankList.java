package ua.study.awesome.androidlessons.testtask_skysoft.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BankList {

    @SerializedName("devices")
    private ArrayList<Bank> bankList;

    /*GETTERS & SETTERS*/

    public ArrayList<Bank> getBankList() {
    return bankList;
}

    public void setBankList(ArrayList<Bank> bankList) {
        this.bankList = bankList;
    }
}