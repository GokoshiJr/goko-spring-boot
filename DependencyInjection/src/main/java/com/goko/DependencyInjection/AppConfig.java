package com.goko.DependencyInjection;

import com.goko.DependencyInjection.repositories.IProductRepository;
import com.goko.DependencyInjection.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:product.json")
    private Resource resource;

    @Bean
    @Primary
    IProductRepository productRepositoryJson() throws IOException {
        return new ProductRepositoryJson(resource);
    }
}
