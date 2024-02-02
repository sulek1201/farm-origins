package com.sulek.farmorigins.dto;

import com.sun.istack.NotNull;
import lombok.Data;


@Data
public class RegistrationRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private Integer userRole;
    @NotNull
    private String phoneNumber;
}
