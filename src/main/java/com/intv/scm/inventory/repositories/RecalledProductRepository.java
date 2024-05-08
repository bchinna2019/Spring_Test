package com.intv.scm.inventory.repositories;

import com.intv.scm.inventory.entities.RecalledProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecalledProductRepository extends JpaRepository<RecalledProduct, Integer> {}
