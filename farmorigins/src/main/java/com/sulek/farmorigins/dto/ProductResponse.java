package com.sulek.farmorigins.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
public class ProductResponse {

    private Long storeId;
    private Long id;
    private String name;
    private String description;
    private String image;
    private Long category_id;
    private BigDecimal price;
    private BigDecimal amount;
    private Long unitTypeId;

}
