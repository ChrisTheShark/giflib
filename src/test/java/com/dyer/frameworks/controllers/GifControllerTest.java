package com.dyer.frameworks.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.dyer.frameworks.model.Gif;
import com.dyer.frameworks.repository.GifRepository;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;

/**
 * Testing for {@link GifController}.
 */
public class GifControllerTest {

    private GifRepository mockGifRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        GifController gifController = new GifController();
        mockGifRepository = EasyMock.createMock(GifRepository.class);
        ReflectionTestUtils.setField(gifController, "gifRepository", mockGifRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(gifController).build();
    }

    @Test
    public void testGetLandingPage() throws Exception {
        EasyMock.expect(mockGifRepository.findAll()).andReturn(Collections.EMPTY_LIST);
        EasyMock.replay(mockGifRepository);
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
        EasyMock.verify(mockGifRepository);
    }

    /*
    @Test
    public void testGetGif() throws Exception {
        String name = "android-explosion";

        EasyMock.expect(mockGifRepository.findByName(name)).andReturn(
                new Gif("android-explosion", 3, LocalDate.of(2015,2,13),
                        "Chris Ramacciotti", false));

        EasyMock.replay(mockGifRepository);
        mockMvc
                .perform(get("/gif/" + name))
                .andExpect(status().isOk())
                .andExpect(view().name("gif-details"));
        EasyMock.verify(mockGifRepository);
    }
    */

}
