package com.sulek.farmorigins.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSummaryResponse {
    private String email;
    private Integer userRole;
    private Long userId;
    private String userName;
}
