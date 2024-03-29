package com.sulek.farmorigins.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    private String email;
    private String accessToken;
    private Integer userRole;
    private Date expiredAt;
    private Long userId;
    private String userName;
}
