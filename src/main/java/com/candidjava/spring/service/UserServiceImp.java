package com.candidjava.spring.service;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    public List<User> getUser() {
        return userDao.getUser();
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public void createUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUserById(int id) {
        userDao.delete(id);
    }

    @Override
    public User updatePartially(User user, int id) {
        userDao.updateCountry(user, id);
        return userDao.findById(id);
    }

    @Override
    public User update(User user, int id) {
        return userDao.update(user, id);
    }

}
