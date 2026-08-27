package com.chhetriSom.billingSoftware.service;

import com.chhetriSom.billingSoftware.io.UserRequest;
import com.chhetriSom.billingSoftware.io.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
