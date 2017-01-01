package com.dyer.frameworks.controllers;

import com.dyer.frameworks.model.Gif;
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

    @RequestMapping("/")
    public String getLandingPage() {
        return "home";
    }

    @RequestMapping("/gif")
    public String getGif(ModelMap modelMap) {
        Gif gif = new Gif("compiler-bot", LocalDate.of(2017, 01, 01), "cdyer", false);
        modelMap.put("gif", gif);
        return "gif-details";
    }

}
