package com.goko.DependencyInjection.repositories;

import com.goko.DependencyInjection.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> getProducts() {
        return Collections.singletonList(
                new Product(1, "Monitor Asus", 600)
        );
    }

    @Override
    public Product getProductById(Integer id) {
        return new Product(id, "Monitor Asus", 600);
    }
}
