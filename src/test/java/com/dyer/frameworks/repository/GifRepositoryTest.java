<<<<<<< HEAD
package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Gif;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

=======
package com.dyer.frameworks.repository

import org.junit.Test;

>>>>>>> 0ae43c1d198540e20c27682843501d79b318c42f
/**
 * Testing for {@link GifRepository}.
 */
public class GifRepositoryTest {

<<<<<<< HEAD
    private SimpleGifRepositoryImpl repository = new SimpleGifRepositoryImpl();

    @Test
    public void testFindByName() throws Exception {
        String name = "android-explosion";

        Gif gif = repository.findByName(name);
        assertNotNull("Located Gif should not be null.", gif);
        assertEquals("Located Gif should have expected name.", name,
                gif.getName());
    }

    @Test
    public void testFindByCategoryId() throws Exception {
        int categoryId = 2;

        List<Gif> gifs = repository.findByCategoryId(categoryId);
        assertNotNull("Located list should not be null", gifs);
        assertEquals("Located list should have expected length.", 2,
                gifs.size());
    }

    @Test
    public void testGetAll() throws Exception {
        List<Gif> gifs = repository.findAll();
        assertNotNull("Static list should not be null", gifs);
        assertEquals("Static list should have expected length.", 6, gifs.size());
=======
    @Test
    public void testGetAllGifs() throws Exception {

>>>>>>> 0ae43c1d198540e20c27682843501d79b318c42f
    }

}