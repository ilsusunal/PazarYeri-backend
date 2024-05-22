package com.example.ecommerce.controller;

import com.example.ecommerce.dto.RegisterUser;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public Customer register(@RequestBody RegisterUser registerUser) {
        return authenticationService.register(registerUser.getFirstName(),
                registerUser.getLastName(),
                registerUser.getEmail(),
                registerUser.getPassword());
    }

}
