package com.candidjava.spring.service;

import com.candidjava.spring.bean.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);

    public List<User> getUser();

    public User findById(int id);

    public User update(User user, int id);

    public User updatePartially(User user, int id);

    public void deleteUserById(int id);

}
