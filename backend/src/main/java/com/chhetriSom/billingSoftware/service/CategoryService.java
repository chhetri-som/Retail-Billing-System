package com.chhetriSom.billingSoftware.service;

import com.chhetriSom.billingSoftware.io.CategoryRequest;
import com.chhetriSom.billingSoftware.io.CategoryResponse;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);
}
