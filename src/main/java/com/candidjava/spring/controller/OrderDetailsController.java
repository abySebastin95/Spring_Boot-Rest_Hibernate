package com.candidjava.spring.controller;

import com.candidjava.spring.bean.OrderDetails;
import com.candidjava.spring.dto.OrderDetailsDto;
import com.candidjava.spring.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService orderDetailsService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDetails> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        OrderDetails user = orderDetailsService.findById(id);
        if (user == null) {
            return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderDetails>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody OrderDetails user, UriComponentsBuilder ucBuilder) {
        orderDetailsService.createUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getOrderDetailsId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "details/get")
    public List<OrderDetailsDto> getOrderDetails() {
        return orderDetailsService.getOrderDetails();
    }

    @GetMapping(value = "/get")
    public List<OrderDetails> getAllUser() {
        return orderDetailsService.getUser();
    }

    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<OrderDetails> deleteUser(@PathVariable("id") int id) {
        OrderDetails user = orderDetailsService.findById(id);
        if (user == null) {
            return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
        }
        orderDetailsService.deleteUserById(id);
        return new ResponseEntity<OrderDetails>(HttpStatus.NO_CONTENT);
    }
}
