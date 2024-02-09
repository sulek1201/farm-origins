package com.sulek.farmorigins.service;

import com.sulek.farmorigins.dto.*;
import com.sulek.farmorigins.entity.Product;
import com.sulek.farmorigins.entity.Store;
import com.sulek.farmorigins.repository.ProductRepository;
import com.sulek.farmorigins.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Boolean createProduct(CreateProductRequest createProductRequest) {

        Store store = storeRepository.findById(createProductRequest.getStoreId())
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + createProductRequest.getStoreId()));

        Product product = Product.builder()
                .amount(createProductRequest.getAmount())
                .category_id(createProductRequest.getCategoryId())
                .price(createProductRequest.getPrice())
                .unitTypeId(createProductRequest.getUnitTypeId())
                .name(createProductRequest.getName())
                .description(createProductRequest.getDescription())
                .image(createProductRequest.getImage())
                .store(store)
                .build();

        productRepository.save(product);
        return true;
    }

    @Override
    public Boolean updateProduct(UpdateProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + productRequest.getId()));

        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        product.setAmount(productRequest.getAmount());
        product.setCategory_id(productRequest.getCategoryId());
        product.setName(productRequest.getName());
        product.setUnitTypeId(productRequest.getUnitTypeId());
        product.setPrice(productRequest.getPrice());

        productRepository.save(product);
        return true;
    }

    @Override
    public Boolean deleteProduct(Long storeId) {
        Product product = productRepository.findById(storeId)
                .orElseThrow(() -> new EntityNotFoundException("Store not found with id: " + storeId));
        productRepository.delete(product);
        return true;
    }


}
