package com.example.ecommerce.dto;

public record DetailedCardResponse(Long id, Long cardNo, Integer expireMonth, Integer expireYear, String nameOnCard ) {
}
