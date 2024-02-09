package com.sulek.farmorigins.service;


import com.sulek.farmorigins.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Boolean createProduct(CreateProductRequest storeRequest);
    Boolean updateProduct(UpdateProductRequest productRequest);
    Boolean deleteProduct(Long storeId);

}
