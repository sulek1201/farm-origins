package com.sulek.farmorigins.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.List;


@Data
public class UpdateStoreRequest {
    @NotNull
    private Long id;
    @NotNull
    private String description;
    private String image;
    @NotNull
    private String address;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    private String vkn;
    @NotNull
    private String name;
}
