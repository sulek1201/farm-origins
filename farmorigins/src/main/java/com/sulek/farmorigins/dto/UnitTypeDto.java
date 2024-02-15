package com.sulek.farmorigins.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class UnitTypeDto {

    private Long value;
    private String label;


}
