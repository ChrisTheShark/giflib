package com.dyer.frameworks.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.dyer.frameworks.model.Category;
import com.dyer.frameworks.model.Gif;
import com.dyer.frameworks.repository.CategoryRepository;
import com.dyer.frameworks.repository.GifRepository;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

/**
 * Testing for {@link CategoryController}.
 */
public class CategoryControllerTest {

    private CategoryRepository mockCategoryRepository;

    private GifRepository mockGifRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        CategoryController categoryController = new CategoryController();
        mockCategoryRepository = EasyMock.createMock(CategoryRepository.class);
        mockGifRepository = EasyMock.createMock(GifRepository.class);
        ReflectionTestUtils.setField(categoryController, "categoryRepository", mockCategoryRepository);
        ReflectionTestUtils.setField(categoryController, "gifRepository", mockGifRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void testGetAllCategories() throws Exception {
        EasyMock.expect(mockCategoryRepository.findAll()).andReturn(Collections.EMPTY_LIST);
        EasyMock.replay(mockGifRepository, mockCategoryRepository);
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(view().name("category-list"));
        EasyMock.verify(mockGifRepository, mockCategoryRepository);
    }

    /*
    @Test
    public void testGetCategoryById() throws Exception {
        int id = 2;

        EasyMock.expect(mockCategoryRepository.findById(id))
                .andReturn(new Category(1, "Technology"));
        EasyMock.expect(mockGifRepository.findByCategoryId(id)).andReturn(
                Arrays.asList(new Gif("android-explosion", 3, LocalDate.of(2015,2,13),
                        "Chris Ramacciotti", false)));

        EasyMock.replay(mockGifRepository, mockCategoryRepository);
        mockMvc.perform(get("/category/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("category"));
        EasyMock.verify(mockGifRepository, mockCategoryRepository);
    }
    */

}
