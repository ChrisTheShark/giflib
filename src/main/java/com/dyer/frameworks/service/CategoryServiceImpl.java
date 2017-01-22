package com.dyer.frameworks.service;

import com.dyer.frameworks.model.Category;
import com.dyer.frameworks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@link CategoryService} implementation uses a {@link CategoryRepository}
 * instance to manage {@link Category}s.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Category category) {
        categoryRepository.delete(category);
    }

}
