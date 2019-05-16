package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data;

import io.realm.Realm;

public class UserRepositoryImpl implements UserRepository {

    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public void onAddUser(UserEntity entity) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insertOrUpdate(entity);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void onRemoveUser(String username) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        UserEntity user = realm.where(UserEntity.class).equalTo("userName", username).findFirst();
        if (user != null) {
            user.deleteFromRealm();
        }
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public UserEntity getUser(String username){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        UserEntity user = realm.where(UserEntity.class).equalTo("userName", username).findFirst();
        realm.commitTransaction();
        realm.close();
        return user;
    }

}