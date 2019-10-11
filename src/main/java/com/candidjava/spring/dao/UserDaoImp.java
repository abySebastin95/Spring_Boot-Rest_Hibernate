package com.candidjava.spring.dao;

import com.candidjava.spring.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public List<User> getUser() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(User.class).list();
    }

    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    public User update(User val, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        user.setCountry(val.getCountry());
        user.setName(val.getName());
        session.update(user);
        return user;
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = findById(id);
        session.delete(user);
    }

    @Override
    public User updateCountry(User val, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        user.setCountry(val.getCountry());
        return user;
    }

}
