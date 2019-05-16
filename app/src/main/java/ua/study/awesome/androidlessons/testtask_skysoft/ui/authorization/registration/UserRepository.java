package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.registration;

import ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data.UserEntity;

public interface UserRepository {

    void onAddUser(UserEntity entity);

    void onRemoveUser(UserEntity entity);

    UserEntity getUser();
}
