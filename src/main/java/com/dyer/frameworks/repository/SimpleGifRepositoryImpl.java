package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Gif;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Simple {@link GifRepository} implementation uses a static {@link List}.
 */
@Repository
public class SimpleGifRepositoryImpl implements GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", 3, LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike", 2, LocalDate.of(2015,10,30), "Ben Jakuben", true),
            new Gif("book-dominos", 3, LocalDate.of(2015,9,15), "Craig Dennis", false),
            new Gif("compiler-bot", 1, LocalDate.of(2015,2,13), "Ada Lovelace", true),
            new Gif("cowboy-coder", 1, LocalDate.of(2015,2,13), "Grace Hopper", false),
            new Gif("infinite-andrew", 2, LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );

    @Override
    public Gif findByName(String name) {
        return ALL_GIFS.stream()
                .filter(gif -> gif.getName().equals(name))
                .findAny()
                .get();
    }

    @Override
    public List<Gif> findByCategoryId(int categoryId) {
        return ALL_GIFS.stream()
                .filter(gif -> gif.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Gif> findAll() {
        return ALL_GIFS;
    }

}
