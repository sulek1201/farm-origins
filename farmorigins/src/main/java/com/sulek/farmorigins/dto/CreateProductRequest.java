package com.sulek.farmorigins.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class CreateProductRequest {

    private Long storeId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private String image;
    @NotNull
    private Long categoryId;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Long unitTypeId;
}
