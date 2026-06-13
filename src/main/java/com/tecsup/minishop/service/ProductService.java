package com.tecsup.minishop.service;

import com.tecsup.minishop.model.Product;
import com.tecsup.minishop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // PASO 5.2: Constantes declaradas para mejorar la legibilidad
    private static final double MIN_PRICE_THRESHOLD = 0.0;
    private static final int MIN_STOCK_THRESHOLD = 0;

    public Product save(Product product) {
        // Antes: product.getPrice() <= 0.0
        if (product.getPrice() == null || product.getPrice() <= MIN_PRICE_THRESHOLD) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        }
        // Antes: product.getStock() < 0
        if (product.getStock() < MIN_STOCK_THRESHOLD) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }
}