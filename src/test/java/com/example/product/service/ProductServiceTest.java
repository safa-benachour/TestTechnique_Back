package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ProductServiceTest {
    private ProductRepository productRepository;

    private ProductService productService;
    @BeforeEach
    public void setup() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void createProduct() {
        Product p = new Product();
        p.setName("test");
        p.setPrice(9.9);
        when(productRepository.save(p)).thenReturn(p);

        Product createdProduct = productService.createProduct(p);

        assertNotNull(createdProduct);
        assertEquals("Test produit", createdProduct.getName());
        assertEquals(20.5, createdProduct.getPrice());
        verify(productRepository, times(1)).save(p);

    }

    @Test
    void deleteProduct() {
    }
}