package com.sulek.farmorigins.service;

import com.sulek.farmorigins.dto.*;
import com.sulek.farmorigins.entity.Product;
import com.sulek.farmorigins.entity.Store;
import com.sulek.farmorigins.entity.User;
import com.sulek.farmorigins.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Boolean createStore(CreateStoreRequest storeRequest, User user) {
        Store store = Store.builder()
                .address(storeRequest.getAddress())
                .description(storeRequest.getDescription())
                .email(storeRequest.getEmail())
                .name(storeRequest.getName())
                .image(storeRequest.getImage())
                .vkn(storeRequest.getVkn())
                .userId(user)
                .build();
        List<Product> productList = new ArrayList<>();

        for(CreateProductRequest productRequest : storeRequest.getProductList()){
            Product product = Product.builder()
                    .amount(productRequest.getAmount())
                    .category_id(productRequest.getCategoryId())
                    .price(productRequest.getPrice())
                    .unitTypeId(productRequest.getUnitTypeId())
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .image(productRequest.getImage())
                    .build();
            productList.add(product);
        }
        store.setProducts(productList);
        storeRepository.save(store);
        return true;
    }

    @Override
    public Boolean updateStore(UpdateStoreRequest storeRequest) {
        Store store = storeRepository.findById(storeRequest.getId()).orElseThrow();
        store.setAddress(storeRequest.getAddress());
        store.setDescription(storeRequest.getDescription());
        store.setImage(storeRequest.getImage());
        store.setEmail(storeRequest.getEmail());
        store.setPhoneNumber(storeRequest.getPhoneNumber());
        store.setVkn(storeRequest.getVkn());
        store.setName(storeRequest.getName());
        storeRepository.save(store);
        return true;
    }

    @Override
    public Boolean deleteStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        storeRepository.delete(store);
        return true;
    }

    @Override
    public List<StoreCardResponseByUser> getStoreCards(User user) {
        List<Store> storeList = storeRepository.findAllByUserId(user);
        List<StoreCardResponseByUser> storeCards = new ArrayList<>();
        for(Store store : storeList){
            StoreCardResponseByUser storeCardResponseByUser = StoreCardResponseByUser.builder()
                    .storeId(store.getId())
                    .name(store.getName())
                    .description(store.getDescription())
                    .image(store.getImage())
                    .build();
            storeCards.add(storeCardResponseByUser);
        }
        return storeCards;
    }

    @Override
    public StoreResponse getStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        StoreResponse storeResponse = StoreResponse.builder()
                .id(storeId)
                .phoneNumber(store.getPhoneNumber())
                .address(store.getAddress())
                .description(store.getDescription())
                .email(store.getEmail())
                .vkn(store.getVkn())
                .name(store.getName())
                .image(store.getImage())
                .build();
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product : store.getProducts()){
           ProductResponse productResponse = ProductResponse.builder()
                   .amount(product.getAmount())
                   .category_id(product.getCategory_id())
                   .storeId(storeId)
                   .image(product.getImage())
                   .name(product.getName())
                   .id(product.getId())
                   .description(product.getDescription())
                   .price(product.getPrice())
                   .unitTypeId(product.getUnitTypeId())
                   .build();
            productResponses.add(productResponse);
        }
        storeResponse.setProducts(productResponses);
        return storeResponse;
    }

}
