package com.dyer.frameworks.controllers;

import com.dyer.frameworks.model.Gif;
import com.dyer.frameworks.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple controller to handle requests for {@link Gif}s.
 */
@Controller
public class GifController {

    @Autowired(required = false)
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String getLandingPage(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.findAll());
        return "gif/index";
    }

    @RequestMapping("/gif/{name}")
    public String getGif(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("gif", gifRepository.findByName(name));
        return "gif/details";
    }

}
