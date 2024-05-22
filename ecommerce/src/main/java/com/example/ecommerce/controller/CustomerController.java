package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Address;
import com.example.ecommerce.entity.Card;
import com.example.ecommerce.service.AddressService;
import com.example.ecommerce.service.CardService;
import com.example.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CustomerController {
    private CustomerService customerService;
    private CardService cardService;
    private AddressService addressService;
    @Autowired
    public CustomerController(CustomerService customerService, CardService cardService, AddressService addressService) {
        this.customerService = customerService;
        this.cardService = cardService;
        this.addressService = addressService;
    }

    //POST Request to endpoint to create: /user/card
    @PostMapping("/{card}")
    public Card createCard(@RequestBody Card card){
        return card;
    }
    //GET request to endpoint to list: /user/card
    //PUT request to “/user/card
    //DELETE request to “/user/card/:cardId” endpoint.

    //GET request to /user/address
    //POST request to same endpoint: /user/address
    //PUT request to /user/address
    //DELETE request to /user/address/:addressId
}
