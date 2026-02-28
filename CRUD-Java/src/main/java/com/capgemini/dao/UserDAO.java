package com.capgemini.dao;

import com.capgemini.entity.User;
import java.util.List;

public interface UserDAO {

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public List<User> getAllUsers();
}
