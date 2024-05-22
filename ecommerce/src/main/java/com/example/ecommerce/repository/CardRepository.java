package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("SELECT c FROM Card c WHERE c.cardNo = :cardNo")
    Optional<Card> findByCardNumber(Long cardNo);
}
