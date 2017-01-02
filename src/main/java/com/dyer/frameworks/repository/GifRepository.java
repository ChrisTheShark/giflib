package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Gif;

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

}