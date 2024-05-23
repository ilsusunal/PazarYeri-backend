package com.example.ecommerce.service;

import com.example.ecommerce.dto.CardResponse;
import com.example.ecommerce.dto.DetailedCardResponse;
import com.example.ecommerce.entity.Card;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.exception.EcommerceException;
import com.example.ecommerce.repository.CardRepository;
import com.example.ecommerce.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;

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
    public DetailedCardResponse save(Card card, Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (!customerOptional.isPresent()) {
            throw new EcommerceException("Customer cannot be found with id: " + customerId, HttpStatus.NOT_FOUND);
        }
        Customer customer = customerOptional.get();

        Optional<Card> existingCard = cardRepository.findByCardNumber(card.getCardNo());
        if (existingCard.isPresent()) {
            throw new EcommerceException("Card with number " + card.getCardNo() + " already exists.", HttpStatus.BAD_REQUEST);
        }

        card.setCustomer(customer);
        Set<Card> cards = customer.getCards();
        cards.add(card);
        customer.setCards(cards);

        customerRepository.save(customer);
        cardRepository.save(card);
        return new DetailedCardResponse(card.getId(), card.getCardNo(), card.getExpireMonth(), card.getExpireYear(), card.getNameOnCard());
    }

    @Override
    public Card update(Long id, Card card) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (cardOptional.isPresent()) {
            Card existingCard = cardOptional.get();

            card.setCustomer(existingCard.getCustomer());

            cardRepository.save(card);
            return card;
        }
        throw new EcommerceException("Card cannot be found with id: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public CardResponse delete(Long id) {
        Card card = findById(id);
        cardRepository.delete(card);
        return new CardResponse(card.getCardNo());
    }

}
