package com.candidjava.spring.service;


import com.candidjava.spring.bean.OrderDetails;
import com.candidjava.spring.dto.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {

    public void createUser(OrderDetails orderDetails);

    public List<OrderDetails> getUser();

    public List<OrderDetailsDto> getOrderDetails();

    public OrderDetails findById(int id);

    public void deleteUserById(int id);

}
