package com.records.client.controller;

import com.records.client.entity.User;
//import com.records.client.entity.VerificationToken;
//import com.records.client.event.RegistrationCompleteEvent;
//import com.records.client.model.PasswordModel;
import com.records.client.model.UserModel;
import com.records.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);

        return "Success";
    }
}
