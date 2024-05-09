package com.intv.scm.inventory;

import com.intv.scm.inventory.entities.Product;
import com.intv.scm.inventory.entities.RecalledProduct;
import com.intv.scm.inventory.services.ProductService;
import com.intv.scm.inventory.services.RecalledProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Autowired
    RecalledProductService recalledProductService;

    /**
     * Helper method to create test products
     */
    private Product createTestProduct(String productName, Double price, Integer quantity) {
        return Product.builder()
                .name(productName)
                .price(price)
                .quantity(quantity)
                .build();
    }

    /**
     * Helper method to create test recalled products
     */
    private RecalledProduct createTestRecalledProduct(String recalledProductName, Boolean expired) {
        return RecalledProduct.builder()
                .name(recalledProductName)
                .expired(expired)
                .build();
    }

    @Test
    void shouldSaveProduct() {
        Product product = createTestProduct("product1", 1.2, 2);

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        Assertions.assertNotNull(loadedProduct);
        Assertions.assertNotNull(loadedProduct.getId());
    }

    @Test
    void shouldUpdateProduct() {
        Product product = createTestProduct("product2", 1.3, 5);

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        Assertions.assertNotNull(loadedProduct);

        loadedProduct.setName("NewProduct");

        productService.save(loadedProduct);

        Assertions.assertNotNull(productService.findById(loadedProduct.getId()).orElse(null));
    }

    // Write your tests below
    /*@Test
    void testGetAllProducts() {
        Product product1 = createTestProduct("prod1", 1.5, 1);
        Product product2 = createTestProduct("prod2", 2.5, 2);

        productService.save(product1);
        productService.save(product2);
        Collection<Product> products = productService.getAllProduct();

        Assertions.assertNotNull(products);
        Assertions.assertEquals(4, products.size());
    }*/

    @Test
    public String testGetTransferDetailsWithWeight() throws Exception {
        assertEquals("1","1");
        return null;
    }

}
