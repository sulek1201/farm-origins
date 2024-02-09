package com.sulek.farmorigins.controller.parameter;

import com.sulek.farmorigins.dto.CategoryDto;
import com.sulek.farmorigins.entity.parameter.Category;
import com.sulek.farmorigins.service.parameter.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/parameter")
@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category-list", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDto>> getCategoryList() throws AuthenticationException {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
