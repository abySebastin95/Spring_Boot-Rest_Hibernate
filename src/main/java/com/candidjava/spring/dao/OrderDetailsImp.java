package com.candidjava.spring.dao;

import com.candidjava.spring.bean.OrderDetails;
import com.candidjava.spring.dto.OrderDetailsDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDetailsImp implements OrderDetailsDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(OrderDetails orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.save(orderDetails);
    }

    public List<OrderDetails> getUser() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(OrderDetails.class).list();
    }

    public OrderDetails findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (OrderDetails) session.get(OrderDetails.class, id);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrderDetails orderDetails = findById(id);
        session.delete(orderDetails);
    }

    public List<OrderDetailsDto> getOrderDetails() {
        Session session = sessionFactory.getCurrentSession();
        List<OrderDetails> orderDetailsList = session.createCriteria(OrderDetails.class).list();
        List<OrderDetailsDto> orderDetailsDtoList = new ArrayList<>();

        for (OrderDetails orderDetails : orderDetailsList) {
            OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
            orderDetailsDto.setUsername(orderDetails.getOrder().getUser().getName());
            orderDetailsDto.setOrderId(orderDetails.getOrder().getOrder_Id());
            orderDetailsDto.setDatetime(orderDetails.getDatetime());
            orderDetailsDto.setItemName(orderDetails.getItems().getItemName());
            orderDetailsDto.setOrderType(orderDetails.getFdType().getFdTypeName());
            orderDetailsDto.setQuantity(orderDetails.getQuantity());
            orderDetailsDtoList.add(orderDetailsDto);
        }
        return orderDetailsDtoList;
    }
}
