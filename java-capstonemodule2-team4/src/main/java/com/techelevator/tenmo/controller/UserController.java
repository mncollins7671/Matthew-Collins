package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController

public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUser(Principal principal){
        String username = principal.getName();
        User user = userDao.getUserByUsername(username);
        return user;
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public User getUserbyId(){
        return null;
    }
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<String> getUsers(){
      return userDao.allUsers();
    }

}


