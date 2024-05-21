package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "card", schema = "ecommerce")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "card_no")
    private Integer cardNo;

    @Column(name = "expire_month")
    private Integer expireMonth;

    @Column(name = "expire_year")
    private Integer expireYear;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
