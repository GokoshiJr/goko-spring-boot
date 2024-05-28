package com.goko.Web.models.dtos;

import lombok.Data;

@Data
public class ParamDto {
    private String message;
    private Integer code;

    public ParamDto(String message) {
        this.message = message;
    }

    public ParamDto(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
