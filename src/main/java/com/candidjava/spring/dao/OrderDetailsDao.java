package com.candidjava.spring.dao;


import com.candidjava.spring.bean.OrderDetails;
import com.candidjava.spring.dto.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsDao {

    public void addUser(OrderDetails user);

    public List<OrderDetails> getUser();

    public OrderDetails findById(int id);

    public List<OrderDetailsDto> getOrderDetails();

    public void delete(int id);
}
