package com.saul.inventory.service;

import com.saul.inventory.entity.Product;
import com.saul.inventory.dto.ProductRequestDTO;
import com.saul.inventory.exception.ResourceNotFoundException;
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

    // 🔍 NUEVO MÉTODO: Busca un producto específico por ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el ID " + id + " no existe en el inventario."));
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
                .orElseThrow(() -> new ResourceNotFoundException("No se puede actualizar. El producto con el ID " + id + " no existe."));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. El producto con el ID " + id + " no existe.");
        }
        productRepository.deleteById(id);
    }

}