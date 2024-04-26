package com.goko.hibernate.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private String name;
    private String lastName;
}
