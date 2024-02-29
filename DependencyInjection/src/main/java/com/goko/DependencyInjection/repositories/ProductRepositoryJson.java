package com.goko.DependencyInjection.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goko.DependencyInjection.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductRepositoryJson implements IProductRepository {
    private List<Product> products;

    public ProductRepositoryJson() throws IOException {
        Resource resource = new ClassPathResource("product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        products = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
    }

    public ProductRepositoryJson(Resource resource) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        products = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
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
