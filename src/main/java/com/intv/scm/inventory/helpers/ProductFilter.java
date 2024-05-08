package com.intv.scm.inventory.helpers;

import com.intv.scm.inventory.entities.Product;
import com.intv.scm.inventory.entities.RecalledProduct;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {

    private final List<RecalledProduct> recalledProducts;

    public ProductFilter(List<RecalledProduct> recalledProducts) {
        this.recalledProducts = recalledProducts;
    }

    public List<Product> removeRecalledFrom(Collection<Product> allProduct) {
        return allProduct.stream().filter(p -> filterByName(p)).collect(Collectors.toList());
    }

    private boolean filterByName(Product product) {
        return !recalledProducts.stream()
                .anyMatch(recall -> !recall.getExpired() && product.getName().equals(recall.getName()));
    }
}
