package com.goko.DependencyInjection.services;

import com.goko.DependencyInjection.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProductById(Integer id);
}
