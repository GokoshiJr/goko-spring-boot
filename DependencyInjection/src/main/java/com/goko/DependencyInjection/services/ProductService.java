package com.goko.DependencyInjection.services;

import java.util.List;
import java.util.stream.Collectors;

import com.goko.DependencyInjection.models.Product;
import com.goko.DependencyInjection.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {


    /*
        Injection with field
        @Autowired
        private IProductRepository productRepository;
    */

    /*
        Injection with setter
        @Autowired
        public void setProductRepository(IProductRepository productRepository) {
            this.productRepository = productRepository;
        }
    */

    @Value("${config.price.tax}")
    private double appTax;

    private IProductRepository productRepository;
    /* Injection with constructor (don´t need @Autowired) */
    public ProductService(/*@Qualifier("productRepository")*/ IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.getProducts().stream().map(product -> {
                Product newProduct = product.clone();
                newProduct.setPrice((int) Math.round(product.getPrice() * appTax));
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Integer id) {
        return this.productRepository.getProductById(id);
    }
}
