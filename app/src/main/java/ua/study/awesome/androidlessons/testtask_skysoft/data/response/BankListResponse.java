package ua.study.awesome.androidlessons.testtask_skysoft.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BankListResponse {

    @SerializedName("devices")
    private ArrayList<BankResponse> bankResponseList;

    /*GETTERS & SETTERS*/

    public ArrayList<BankResponse> getBankResponseList() {
    return bankResponseList;
}

    public void setBankResponseList(ArrayList<BankResponse> bankResponseList) {
        this.bankResponseList = bankResponseList;
    }
}