package com.saul.inventory.service;

import com.saul.inventory.entity.Product;
import com.saul.inventory.dto.ProductRequestDTO;
import com.saul.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductRequestDTO dto) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(dto.getName());
                    existingProduct.setQuantity(dto.getQuantity());
                    existingProduct.setPrice(dto.getPrice());
                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Producto no encontrado con el ID: " + id);
        }
        productRepository.deleteById(id);
    }
}