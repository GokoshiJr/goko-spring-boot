package com.goko.Invoice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Client {
    @Value("${client.name}")
    private String name;

    @Value("${client.lastName}")
    private String lastName;
}
