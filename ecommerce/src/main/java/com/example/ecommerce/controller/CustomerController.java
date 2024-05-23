package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CardResponse;
import com.example.ecommerce.dto.DetailedCardResponse;
import com.example.ecommerce.entity.Card;
import com.example.ecommerce.exception.EcommerceException;
import com.example.ecommerce.service.AddressService;
import com.example.ecommerce.service.CardService;
import com.example.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    //Card
    @PostMapping("/{card}")
    public ResponseEntity<DetailedCardResponse> createCard(@RequestBody Card card, @RequestParam Long customerId){
        DetailedCardResponse savedCard = cardService.save(card, customerId);
        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }
    @GetMapping("/card")
    public List<Card> getAll(){
        return cardService.findAll();
    }
    @PutMapping("/card/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestBody Card card) {
        try {
            Card updatedCard = cardService.update(cardId, card);
            return new ResponseEntity<>(updatedCard, HttpStatus.OK);
        } catch (EcommerceException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/card/{cardId}")
    public CardResponse delete(@PathVariable("cardId") Long id){
        return cardService.delete(id);
    }

    //Address

    //GET request to /user/address
    //POST request to same endpoint: /user/address
    //PUT request to /user/address
    //DELETE request to /user/address/:addressId
}
