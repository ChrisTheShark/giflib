package com.dyer.frameworks.controllers;

import com.dyer.frameworks.model.Gif;
import com.dyer.frameworks.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * Simple controller to handle requests for gifs.
 */
@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String getLandingPage() {
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String getGif(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("gif", gifRepository.findByName(name));
        return "gif-details";
    }

}
