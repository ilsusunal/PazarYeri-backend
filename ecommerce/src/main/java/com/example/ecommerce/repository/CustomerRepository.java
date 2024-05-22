package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT u FROM Customer u WHERE u.email = :email")
    Optional<Customer> findUserByEmail(String email);

//    @Query(value = "SELECT p.id, p.name, p.price FROM selectProductsWithPrice(:price) as p", nativeQuery = true)
//    List<Products> findProductByPrice(double price);
}
