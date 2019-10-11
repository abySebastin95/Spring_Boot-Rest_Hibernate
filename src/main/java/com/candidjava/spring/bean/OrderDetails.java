package com.candidjava.spring.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderdetails")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderDetailsId;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @OneToOne
    @JoinColumn(name = "orderType")
    private FoodTimeType fdType;

    @OneToOne
    @JoinColumn(name = "itemId")
    private Items items;

    private Integer quantity;
    private Date datetime;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public FoodTimeType getFdType() {
        return fdType;
    }

    public void setFdType(FoodTimeType fdType) {
        this.fdType = fdType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
}
