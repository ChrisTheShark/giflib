package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Category;

import java.util.List;

/**
 * Simple repository for {@link Category} objects.
 */
public interface CategoryRepository {

    /**
     * Find a {@link Category} by <code>int</code> identifier.
     * @param id the <code>int</code> identifier
     * @return a located {@link Category} object
     */
    Category findById(int id);

    /**
     * Find all {@link Category} objects.
     * @return a located {@link List} of {@link Category}s.
     */
    List<Category> findAll();

}
