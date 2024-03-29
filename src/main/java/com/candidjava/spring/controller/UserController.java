package com.candidjava.spring.controller;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/create", headers = "Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getName());
        userService.createUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public List<User> getAllUser() {
        return userService.getUser();
    }

    @PutMapping(value = "/update", headers = "Accept=application/json")
    public ResponseEntity<String> updateUser(@RequestBody User currentUser) {
        System.out.println("sd");
        User user = userService.findById(currentUser.getId());
        if (user == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        userService.update(currentUser, currentUser.getId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<User> updateUserPartially(@PathVariable("id") int id, @RequestBody User currentUser) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        User usr = userService.updatePartially(currentUser, id);
        return new ResponseEntity<User>(usr, HttpStatus.OK);
    }
}
