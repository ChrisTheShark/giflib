package com.dyer.frameworks.service;

import com.dyer.frameworks.model.Category;

import java.util.List;

/**
 * Simple service for managing {@link Category} objects.
 */
public interface CategoryService {

    /**
     * Get a {@link Category} by <code>Long</code> identifier.
     * @param id the <code>Long</code> identifier
     * @return a located {@link Category} object
     */
    Category getCategoryById(Long id);

    /**
     * Get all {@link Category} objects.
     * @return a located {@link List} of {@link Category}s.
     */
    List<Category> getAllCategories();

    /**
     * Add a {@link Category} object.
     * @param category the {@link Category} object to add
     */
    void addCategory(Category category);

    /**
     * Remove a {@link Category} object.
     * @param category the {@link Category} object to remove
     */
    void removeCategory(Category category);

}
