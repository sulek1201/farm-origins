package com.sulek.farmorigins.service;





import com.sulek.farmorigins.dto.*;
import com.sulek.farmorigins.entity.Store;
import com.sulek.farmorigins.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    Boolean createStore(CreateStoreRequest storeRequest, User user);
    Boolean updateStore(UpdateStoreRequest storeRequest);
    Boolean deleteStore(Long storeId);
    List<StoreCardResponseByUser> getStoreCards(User user);
    StoreResponse getStore(Long storeId);


}
