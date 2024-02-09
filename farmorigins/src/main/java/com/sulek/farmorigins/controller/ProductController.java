package com.sulek.farmorigins.controller;

import com.sulek.farmorigins.dto.*;
import com.sulek.farmorigins.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/api/product")
@RestController
@CrossOrigin
public class ProductController {


   @Autowired
   private ProductServiceImpl productService;

    @RequestMapping(value = "/create-product", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(productService.createProduct(createProductRequest));
    }

    @RequestMapping(value = "/update-product", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateProduct(@RequestBody UpdateProductRequest productRequest) {
        return ResponseEntity.ok(productService.updateProduct(productRequest));
    }

    @RequestMapping(value = "/delete-product/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }

}
