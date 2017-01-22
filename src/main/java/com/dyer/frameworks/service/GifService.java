package com.dyer.frameworks.service;

import com.dyer.frameworks.model.Gif;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Simple service for managing {@link Gif} objects.
 */
public interface GifService {

    /**
     * Get all {@link Gif} objects.
     * @return a located {@link List} of {@link Gif} objects
     */
    List<Gif> getAll();

    /**
     * Get a {@link Gif} by {@link Long} identifier.
     * @param identifier the {@link Long} identifier
     * @return a located {@link Gif} object or <code>null</code>
     */
    Gif getById(Long identifier);

    /**
     * Save a {@link Gif} object and it's accompanying {@link MultipartFile}
     * object.
     * @param gif the {@link Gif} object
     * @param file the accompanying {@link MultipartFile} object
     */
    void save(Gif gif, MultipartFile file);

    /**
     * Remove a {@link Gif} object.
     * @param gif the {@link Gif} object
     */
    void remove(Gif gif);

}
