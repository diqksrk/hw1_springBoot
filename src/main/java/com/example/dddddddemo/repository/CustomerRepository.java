package com.example.dddddddemo.repository;

import com.example.dddddddemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findByName(String name);
    public List<Customer> findByPhone(String name);

    public List<Customer> findByNameLike(String keyword);
}