package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testing for {@link CategoryRepository}.
 */
public class CategoryRepositoryTest {

    private SimpleCategoryRepositoryImpl repository = new SimpleCategoryRepositoryImpl();

    @Test
    public void testFindById() throws Exception {
        int id = 2;

        Category category = repository.findById(id);
        assertNotNull("Located category should not be null.", category);
        assertEquals("Static category should have expected id.", id,
                category.getId());
    }

    @Test
    public void testGetAll() throws Exception {
        List<Category> categories = repository.findAll();
        assertNotNull("Static list should not be null", categories);
        assertEquals("Static list should have expected length.", 3, categories.size());
    }

}
