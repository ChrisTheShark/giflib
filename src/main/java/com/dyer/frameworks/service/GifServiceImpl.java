package com.dyer.frameworks.service;

import com.dyer.frameworks.model.Gif;
import com.dyer.frameworks.repository.GifRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * {@link GifService} implementation uses a {@link GifRepository}
 * instance to manage {@link Gif}s.
 */
@Service
public class GifServiceImpl implements GifService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GifService.class);

    @Autowired
    private GifRepository gifRepository;

    @Override
    public List<Gif> getAll() {
        return gifRepository.findAll();
    }

    @Override
    public Gif getById(Long identifier) {
        return gifRepository.findById(identifier);
    }

    @Override
    public void save(Gif gif, MultipartFile file) {
        try {
            gif.setBytes(file.getBytes());
            gifRepository.save(gif);
        } catch (IOException e) {
            LOGGER.error("Unable to get bytes for file.", e);
        }

    }

    @Override
    public void remove(Gif gif) {
        gifRepository.delete(gif);
    }

}
