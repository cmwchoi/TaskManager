package com.cmwchoi.dao;


import com.cmwchoi.models.User;

/**
 * Created by Christian on 5/27/16.
 */
public interface UserDao {

    User create(User user);
    User get(Integer id);
    void update(User user);
    void delete(Integer id);

}
