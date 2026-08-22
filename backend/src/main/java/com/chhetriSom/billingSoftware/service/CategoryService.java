package com.chhetriSom.billingSoftware.service;

import com.chhetriSom.billingSoftware.io.CategoryRequest;
import com.chhetriSom.billingSoftware.io.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);

    List<CategoryResponse> read();
}
