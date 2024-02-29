package com.goko.DependencyInjection.repositories;

import com.goko.DependencyInjection.models.Product;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository implements IProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = Arrays.asList(
                new Product(1, "Memoria Ram 2", 10),
                new Product(2, "Teclado Mecanico", 15),
                new Product(3, "Monitor HD", 20),
                new Product(4, "Mouse X", 5),
                new Product(5, "Platanitos Natuchips 150g", 5)
        );
    }

    @Override
    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public Product getProductById(Integer id) {
        return this.products.stream()
                .filter(el -> Objects.equals(el.getId(), id))
                .findFirst()
                .orElseThrow();
    }
}
