package com.chhetriSom.billingSoftware.controller;

import com.chhetriSom.billingSoftware.io.CategoryRequest;
import com.chhetriSom.billingSoftware.io.CategoryResponse;
import com.chhetriSom.billingSoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request) {
        return categoryService.add(request);
    }
}
