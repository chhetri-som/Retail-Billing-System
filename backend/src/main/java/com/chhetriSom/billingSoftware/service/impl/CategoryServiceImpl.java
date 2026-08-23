package com.chhetriSom.billingSoftware.service.impl;

import com.chhetriSom.billingSoftware.entity.CategoryEntity;
import com.chhetriSom.billingSoftware.io.CategoryRequest;
import com.chhetriSom.billingSoftware.io.CategoryResponse;
import com.chhetriSom.billingSoftware.repository.CategoryRepository;
import com.chhetriSom.billingSoftware.service.CategoryService;
import com.chhetriSom.billingSoftware.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;

    @Override
    public CategoryResponse add(CategoryRequest request, MultipartFile file) {
        String imgUrl = fileUploadService.uploadFile(file);
        CategoryEntity newCategory = convertToEntity(request);
        newCategory.setImgUrl(imgUrl);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> read() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryId));
        fileUploadService.deleteFile(existingCategory.getImgUrl());
        categoryRepository.delete(existingCategory);
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }
}
