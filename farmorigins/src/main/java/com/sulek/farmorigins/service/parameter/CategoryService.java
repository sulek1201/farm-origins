package com.sulek.farmorigins.service.parameter;

import com.sulek.farmorigins.dto.CategoryDto;
import com.sulek.farmorigins.entity.parameter.Category;
import com.sulek.farmorigins.repository.parameter.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();

        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category : categoryList){
            CategoryDto categoryDto = new CategoryDto(category.getId()-1L, category.getLabel());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}
