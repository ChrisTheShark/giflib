package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Category;
import com.dyer.frameworks.model.Gif;

import java.util.List;

/**
 * Simple repository for {@link Gif} objects.
 */
public interface GifRepository {

    /**
     * Locate a {@link Gif} object by <code>String</code> name.
     * @param name the <code>String</code> name
     * @return a located {@link Gif} object or <code>null</code>.
     */
    Gif findByName(String name);

    /**
     * Find a {@link List} of {@link Gif}s by <code>int</code>
     * {@link Category} identifier.
     * @param categoryId the <code>int</code> {@link Category} identifier.
     * @return a located {@link Gif} object or an empty {@link List}.
     */
    List<Gif> findByCategoryId(int categoryId);

    /**
     * Find all {@link Gif}s.
     * @return a located {@link List}
     */
    List<Gif> findAll();

}