package com.sulek.farmorigins.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class StoreCardResponseByUser {

    private Long storeId;
    private String name;
    private String description;
    private String image;

}
