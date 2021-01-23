package com.test.mapper;

import com.test.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> getAll();
    public void addUser(User u);
    public User query(int id);
    public void delUser(int id);
    public void updateUser(User user);
    public List<User> getUser(String name);

}
