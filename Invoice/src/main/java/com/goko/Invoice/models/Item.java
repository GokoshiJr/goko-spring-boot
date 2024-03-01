package com.goko.Invoice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Product product;

    private Integer quantity;
    public Integer getTotalItem() {
        return this.quantity * this.product.getPrice();
    }
}
