package com.sulek.farmorigins.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class UpdateProductRequest {
    @NotNull
    private Long id;
    private String description;
    private String image;
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private BigDecimal amount;
    private Long unitTypeId;
}
