package com.fincore.fincore.mapper;

import com.fincore.fincore.dto.CategoryResponse;
import com.fincore.fincore.dto.CreateCategoryRequest;
import com.fincore.fincore.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CreateCategoryRequest request);

    CategoryResponse toResponse(Category category);
}
