package com.intv.scm.inventory.repositories;

import com.intv.scm.inventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {

    @Override
    Optional<Product> findById(Integer integer);
}
