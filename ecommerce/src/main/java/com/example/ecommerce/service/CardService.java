package com.example.ecommerce.service;

import com.example.ecommerce.dto.CardResponse;
import com.example.ecommerce.dto.DetailedCardResponse;
import com.example.ecommerce.entity.Card;

import java.util.List;
import java.util.Set;

public interface CardService {
    //GET request to endpoint to list: /user/card
    //PUT request to “/user/card
    //DELETE request to “/user/card/:cardId” endpoint.
    Card findById(Long id);
    List<Card> findAll();
    DetailedCardResponse save(Card card, Long customerId);
    Card update(Long id, Card card);
    CardResponse delete(Long id);
}
