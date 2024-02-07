package com.sulek.farmorigins.dto;

import com.sulek.farmorigins.entity.Product;
import com.sulek.farmorigins.entity.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Builder
public class StoreResponse {

    private Long id;
    private String name;
    private String description;
    private String image;
    private String address;
    private String email;
    private String phoneNumber;
    private String vkn;
    private List<ProductResponse> products;

}
