package ua.study.awesome.androidlessons.testtask_skysoft.data.entity;

import java.util.List;

import io.realm.Realm;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.Bank;
import ua.study.awesome.androidlessons.testtask_skysoft.data.response.TimeWork;
import ua.study.awesome.androidlessons.testtask_skysoft.interfaces.ModelInterface;

public class Model implements ModelInterface {

    @Override     /*саня сказав це зветься мапити*/
    public RealmBankModel transformBank(Bank bank) {
        if (bank == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final RealmBankModel realmBankModel = new RealmBankModel();
        realmBankModel.setType(bank.getType());
        realmBankModel.setCityRU(bank.getCityRU());
        realmBankModel.setCityUA(bank.getCityUA());
        realmBankModel.setCityEN(bank.getCityEN());
        realmBankModel.setFullAddressRu(bank.getCityRU());
        realmBankModel.setFullAddressUa(bank.getFullAddressUa());
        realmBankModel.setFullAddressEn(bank.getFullAddressEn());
        realmBankModel.setPlaceRu(bank.getPlaceRu());
        realmBankModel.setPlaceUa(bank.getPlaceUa());
        realmBankModel.setLatitude(bank.getLatitude());
        realmBankModel.setLongitude(bank.getLongitude());
        realmBankModel.setTw(transformBankTimeWork(bank.getTw()));

        return realmBankModel;
    }

    @Override
    public RealmTimeWorkModel transformBankTimeWork(TimeWork timeWork) {
        final RealmTimeWorkModel realmTimeWorkModel = new RealmTimeWorkModel();
        if (timeWork != null) {
            realmTimeWorkModel.setFri(timeWork.getFri());
            realmTimeWorkModel.setHol(timeWork.getHol());
            realmTimeWorkModel.setMon(timeWork.getMon());
            realmTimeWorkModel.setSat(timeWork.getSat());
            realmTimeWorkModel.setSun(timeWork.getSun());
            realmTimeWorkModel.setThu(timeWork.getThu());
            realmTimeWorkModel.setTue(timeWork.getTue());
            realmTimeWorkModel.setWed(timeWork.getWed());
        }
        return realmTimeWorkModel;
    }

//    public RealmBankListModel transformBankList(BankList bankList) {
//        if (bankList == null) {
//            throw new IllegalArgumentException("Cannot transform a null value");
//        }
//        final RealmBankListModel realmBankListModel = new RealmBankListModel();
//        realmBankListModel.setRealmBankModelArrayList(transformBank(bankList.getBankList()));
//
//        return realmBankListModel;
//    }

    @Override
    public void addBrowse(List<RealmBankModel> realmBanks) {
        Realm mRealm = Realm.getDefaultInstance();
        mRealm.beginTransaction();
        mRealm.insertOrUpdate(realmBanks);
        mRealm.commitTransaction();
        mRealm.close();
    }
}