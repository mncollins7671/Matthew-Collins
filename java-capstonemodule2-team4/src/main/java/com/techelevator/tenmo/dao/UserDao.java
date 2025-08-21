package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.dto.RegisterUserDto;
import com.techelevator.tenmo.model.User;

import java.util.List;

public interface UserDao {
    List<String> allUsers();

    User getUserById(Integer id);

    User getUserByUsername(String username);

    User createUser(User user);
}
