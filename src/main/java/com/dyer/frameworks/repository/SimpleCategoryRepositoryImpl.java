package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Simple {@link CategoryRepository} implementation uses a static {@link List}.
 */
@Repository
public class SimpleCategoryRepositoryImpl implements CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Technology"),
            new Category(2, "People"),
            new Category(3, "Destruction")
    );

    @Override
    public Category findById(int id) {
        return ALL_CATEGORIES.stream()
                .filter(category -> category.getId() == id)
                .findAny()
                .get();
    }

    @Override
    public List<Category> findAll() {
        return ALL_CATEGORIES;
    }

}
