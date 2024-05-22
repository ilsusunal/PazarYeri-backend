package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
