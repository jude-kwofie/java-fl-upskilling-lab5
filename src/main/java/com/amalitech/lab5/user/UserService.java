package com.amalitech.lab5.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserModel getUserById(long id);
    UserDetailsService userDetailsService();
    List<UserModel> getAllUsers();

    UserModel createUser(UserModel user);

    UserModel updateUser(long id, UserModel user);

    void deleteUser(long id);
}
