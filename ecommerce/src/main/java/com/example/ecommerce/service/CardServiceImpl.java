package com.example.ecommerce.service;

import com.example.ecommerce.dto.CardResponse;
import com.example.ecommerce.entity.Card;
import com.example.ecommerce.exception.EcommerceException;
import com.example.ecommerce.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CardServiceImpl implements CardService{
    private CardRepository cardRepository;
    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card findById(Long id) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if(cardOptional.isPresent()){return cardOptional.get();}
        throw new EcommerceException("Card cannot found with id :" + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(Long id, Card card) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if(cardOptional.isPresent()){
            cardRepository.save(card);
            return card;
        }
        throw new EcommerceException("Card cannot found with id :" + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public CardResponse delete(Long id) {
        Card card = findById(id);
        cardRepository.delete(card);
        return new CardResponse(card.getCardNo());
    }
}
