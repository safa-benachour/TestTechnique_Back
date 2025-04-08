package com.example.product.service;
import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setCode(updatedProduct.getCode());
                    product.setName(updatedProduct.getName());
                    product.setDescription(updatedProduct.getDescription());
                    product.setImage(updatedProduct.getImage());
                    product.setCategory(updatedProduct.getCategory());
                    product.setPrice(updatedProduct.getPrice());
                    product.setQuantity(updatedProduct.getQuantity());
                    product.setInternalReference(updatedProduct.getInternalReference());
                    product.setShellId(updatedProduct.getShellId());
                    product.setInventoryStatus(updatedProduct.getInventoryStatus());
                    product.setRating(updatedProduct.getRating());
                    product.setUpdatedAt(System.currentTimeMillis());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
