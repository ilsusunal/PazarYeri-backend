package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@Entity
@Table(name = "customer", schema = "ecommerce")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "customerId")
    private List<Order> orders;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "customer")
    private Set<Card> cards;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "customer_adress", schema = "ecommerce",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addressSet;
}
