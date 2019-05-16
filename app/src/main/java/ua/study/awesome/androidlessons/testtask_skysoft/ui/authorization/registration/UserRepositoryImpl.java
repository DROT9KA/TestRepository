package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.registration;

import io.realm.Realm;
import io.realm.RealmResults;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserEntity;

class UserRepositoryImpl implements UserRepository {

    private final Realm realm = Realm.getDefaultInstance();

    @Override
    public void onAddUser(UserEntity entity) {
        realm.beginTransaction();
        realm.insertOrUpdate(entity);
        realm.commitTransaction();
    }

    @Override
    public void onRemoveUser(UserEntity entity) {
        RealmResults<UserEntity> users = realm.where(UserEntity.class).findAll();

        if(!users.isEmpty()){
            for(int i = users.size(); i > 0; i--){
                users.get(i).deleteFromRealm();
            }
        }
    }

    @Override
    public UserEntity getUser(){

        return null;
    }

}