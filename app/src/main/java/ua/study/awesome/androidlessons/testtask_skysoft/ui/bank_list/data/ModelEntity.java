package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankResponse;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.TimeWorkResponse;

public class ModelEntity implements ModelInterface {

    @Override     /*саня сказав це зветься мапити*/
    public RealmBankModelEntity transformBank(BankResponse bankResponse) {
        if (bankResponse == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final RealmBankModelEntity realmBankModelEntity = new RealmBankModelEntity();
        realmBankModelEntity.setType(bankResponse.getType());
        realmBankModelEntity.setCityRU(bankResponse.getCityRU());
        realmBankModelEntity.setCityUA(bankResponse.getCityUA());
        realmBankModelEntity.setCityEN(bankResponse.getCityEN());
        realmBankModelEntity.setFullAddressRu(bankResponse.getCityRU());
        realmBankModelEntity.setFullAddressUa(bankResponse.getFullAddressUa());
        realmBankModelEntity.setFullAddressEn(bankResponse.getFullAddressEn());
        realmBankModelEntity.setPlaceRu(bankResponse.getPlaceRu());
        realmBankModelEntity.setPlaceUa(bankResponse.getPlaceUa());
        realmBankModelEntity.setLatitude(bankResponse.getLatitude());
        realmBankModelEntity.setLongitude(bankResponse.getLongitude());
        realmBankModelEntity.setTw(transformBankTimeWork(bankResponse.getTw()));

        return realmBankModelEntity;
    }

    @Override
    public RealmTimeWorkModelEntity transformBankTimeWork(TimeWorkResponse timeWorkResponse) {
        final RealmTimeWorkModelEntity realmTimeWorkModelEntity = new RealmTimeWorkModelEntity();
        if (timeWorkResponse != null) {
            realmTimeWorkModelEntity.setFri(timeWorkResponse.getFri());
            realmTimeWorkModelEntity.setHol(timeWorkResponse.getHol());
            realmTimeWorkModelEntity.setMon(timeWorkResponse.getMon());
            realmTimeWorkModelEntity.setSat(timeWorkResponse.getSat());
            realmTimeWorkModelEntity.setSun(timeWorkResponse.getSun());
            realmTimeWorkModelEntity.setThu(timeWorkResponse.getThu());
            realmTimeWorkModelEntity.setTue(timeWorkResponse.getTue());
            realmTimeWorkModelEntity.setWed(timeWorkResponse.getWed());
        }
        return realmTimeWorkModelEntity;
    }

//    public RealmBankListModel transformBankList(BankListResponse bankList) {
//        if (bankList == null) {
//            throw new IllegalArgumentException("Cannot transform a null value");
//        }
//        final RealmBankListModel realmBankListModel = new RealmBankListModel();
//        realmBankListModel.setRealmBankModelArrayList(transformBank(bankList.getBankResponseList()));
//
//        return realmBankListModel;
//    }

//    public void addBrowse(List<RealmBankModelEntity> realmBanks) {
//        Realm mRealm = Realm.getDefaultInstance();
//        mRealm.beginTransaction();
//        mRealm.insertOrUpdate(realmBanks);
//        mRealm.commitTransaction();
//        mRealm.close();
//    }
}