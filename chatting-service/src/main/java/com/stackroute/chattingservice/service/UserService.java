package com.stackroute.chattingservice.service;


import java.util.List;

import com.stackroute.chattingservice.exceptions.UserAlreadyExistException;
import com.stackroute.chattingservice.exceptions.UserNotFoundException;
import com.stackroute.chattingservice.model.User;

public interface UserService {
    List<User> getall() throws UserNotFoundException;

    User addUser(User user) throws UserAlreadyExistException;

    User getUserByUserName(String username)  throws UserNotFoundException;
}

