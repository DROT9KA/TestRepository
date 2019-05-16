package ua.study.awesome.androidlessons.testtask_skysoft.ui.authorization.data;

public interface UserRepository {

    void onAddUser(UserEntity entity);

    void onRemoveUser(String username);

    UserEntity getUser(String username);
}