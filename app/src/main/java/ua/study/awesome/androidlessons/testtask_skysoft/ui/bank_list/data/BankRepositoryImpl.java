package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data;

import io.realm.Realm;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.Entity.BanksEntity;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response.BankResponse;

public class BankRepositoryImpl implements BankRepository {

    private final Realm realm = Realm.getDefaultInstance();

    private BanksMapper maper = new BanksMapperImpl();

    @Override
    public void onAddBanks(BankResponse response) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        BanksEntity realmBankEntities = maper.transformResponseBankToEntity(response, response.hashCode());
        realm.insertOrUpdate(realmBankEntities);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void onRemoveBank(String username) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        realm.commitTransaction();
        realm.close();

    }

    @Override
    public UserEntity getBanks(String username) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        realm.commitTransaction();
        realm.close();
        return null;
    }
}