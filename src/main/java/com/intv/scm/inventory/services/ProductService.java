package com.intv.scm.inventory.services;

import com.intv.scm.inventory.entities.Product;
import com.intv.scm.inventory.entities.RecalledProduct;
import com.intv.scm.inventory.helpers.ProductFilter;
import com.intv.scm.inventory.repositories.InventoryRepository;
import com.intv.scm.inventory.repositories.RecalledProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final InventoryRepository inventoryRepository;
    private final RecalledProductRepository recalledProductRepository;

    @Transactional
    public Product save(Product product) {
        return inventoryRepository.save(product);
    }

    public Collection<Product> getAllProduct() {
        List<RecalledProduct> recalledProducts = recalledProductRepository.findAll();
        ProductFilter filter = new ProductFilter(recalledProducts);

        return filter.removeRecalledFrom(inventoryRepository.findAll());
    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
}
