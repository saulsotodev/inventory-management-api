package com.saul.inventory.controller;

import com.saul.inventory.entity.Product;
import com.saul.inventory.dto.ProductRequestDTO;
import com.saul.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1. Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // 🔍 2. NUEVO ENDPOINT: Obtener un producto específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // 3. Crear un nuevo producto (Protegido con validaciones DTO)
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequestDTO dto) {
        return new ResponseEntity<>(productService.createProduct(dto), HttpStatus.CREATED);
    }

    // 4. Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO dto) {
        return ResponseEntity.ok(productService.updateProduct(id, dto));
    }

    // 5. Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}