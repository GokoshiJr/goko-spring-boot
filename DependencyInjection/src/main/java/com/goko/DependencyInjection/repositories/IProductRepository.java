package com.goko.DependencyInjection.repositories;

import com.goko.DependencyInjection.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProducts();

    Product getProductById(Integer id);

}
