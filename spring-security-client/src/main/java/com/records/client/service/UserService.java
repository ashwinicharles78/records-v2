package com.records.client.service;

import com.records.client.entity.User;
//import com.records.client.entity.VerificationToken;
import com.records.client.model.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);
    User findUserByEmail(String email);
}
