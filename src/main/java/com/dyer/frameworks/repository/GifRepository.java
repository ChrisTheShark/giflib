package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Gif;

import java.util.List;

/**
 * Simple repository for {@link Gif} objects.
 */
public interface GifRepository {

    /**
     * Find a {@link List} of {@link Gif}s by <code>Long</code>
     * identifier.
     * @param identifier the <code>Long</code> identifier.
     * @return a located {@link Gif} object or an empty {@link List}.
     */
    Gif findById(Long identifier);

    /**
     * Find all {@link Gif}s.
     * @return a located {@link List}
     */
    List<Gif> findAll();

    /**
     * Save a {@link Gif} object.
     * @param gif the {@link Gif} object
     */
    void save(Gif gif);

    /**
     * Delete a {@link Gif} object.
     * @param gif the {@link Gif} object
     */
    void delete(Gif gif);

}