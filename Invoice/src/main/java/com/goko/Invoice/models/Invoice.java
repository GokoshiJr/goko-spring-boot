package com.goko.Invoice.models;

/* import com.fasterxml.jackson.annotation.JsonIgnoreProperties; */
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/* import org.springframework.web.context.annotation.RequestScope; */

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Invoice {
    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    @Qualifier("getInvoiceItemsOffice")
    private List<Item> items;

    public Integer getTotal() {
        return items.stream().mapToInt(Item::getTotalItem).sum();
    }

    @PostConstruct
    public void init() {
        System.out.println("epa alex " + client.getName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destruyendo el bean");
    }
}
