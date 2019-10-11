package com.candidjava.spring.service;

import com.candidjava.spring.bean.OrderDetails;
import com.candidjava.spring.dao.OrderDetailsDao;
import com.candidjava.spring.dto.OrderDetailsDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailsServiceImp implements OrderDetailsService {

    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Autowired
    private SessionFactory sessionFactory;


    public List<OrderDetails> getUser() {
        return orderDetailsDao.getUser();
    }

    @Override
    public List<OrderDetailsDto> getOrderDetails() {
        return orderDetailsDao.getOrderDetails();
    }

    public OrderDetails findById(int id) {
        return orderDetailsDao.findById(id);
    }

    public void createUser(OrderDetails user) {
        orderDetailsDao.addUser(user);
    }

    public void deleteUserById(int id) {
        orderDetailsDao.delete(id);
    }
}
