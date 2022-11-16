package org.stolypin.pp231crud.web.service;

import org.stolypin.pp231crud.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public  void saveUser (User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
