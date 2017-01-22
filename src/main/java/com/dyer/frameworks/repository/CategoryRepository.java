package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Category;

import java.util.List;

/**
 * Simple repository for persisting {@link Category} objects.
 */
public interface CategoryRepository {

    /**
     * Find a {@link Category} by <code>Long</code> identifier.
     * @param id the <code>Long</code> identifier
     * @return a located {@link Category} object
     */
    Category findById(Long id);

    /**
     * Find all {@link Category} objects.
     * @return a located {@link List} of {@link Category}s.
     */
    List<Category> findAll();

    /**
     * Persist a {@link Category} object.
     * @param category the {@link Category} object to persist
     */
    void save(Category category);

    /**
     * Delete a {@link Category} object.
     * @param category the {@link Category} object to delete
     */
    void delete(Category category);

}
