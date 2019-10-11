package com.candidjava.spring.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordertable")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_Id;
    private Integer orderSeatNo;

    @ManyToOne
    @JoinColumn(name = "userdetails_Id")
    private User user;

    private Integer itemsCount;
    private Date orderDateTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Integer order_Id) {
        this.order_Id = order_Id;
    }

    public Integer getOrderSeatNo() {
        return orderSeatNo;
    }

    public void setOrderSeatNo(Integer orderSeatNo) {
        this.orderSeatNo = orderSeatNo;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
}
