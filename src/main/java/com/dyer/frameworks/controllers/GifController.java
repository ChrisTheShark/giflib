package com.dyer.frameworks.controllers;

import com.dyer.frameworks.model.Gif;
import com.dyer.frameworks.repository.GifRepository;
import com.dyer.frameworks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Simple controller to handle requests for {@link Gif}s.
 */
@Controller
public class GifController {

    @Autowired
    private CategoryService categoryService;

    @Autowired(required = false)
    private GifRepository gifRepository;

    @RequestMapping(value = "/upload")
    public String formNewGif(Model model) {
        if (!model.containsAttribute("gif")) {
            model.addAttribute("gif", new Gif());
        }
        model.addAttribute("categories", categoryService.getAllCategories());
        return "gif/form";
    }

    @RequestMapping(value = "/gifs", method = RequestMethod.POST)
    public String addGif(@RequestParam MultipartFile file) {

    }

    @RequestMapping("/")
    public String getLandingPage(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.findAll());
        return "gif/index";
    }

    @RequestMapping("/gif/{name}")
    public String getGif(@PathVariable String name, ModelMap modelMap) {
        //modelMap.put("gif", gifRepository.findByName(name));
        return "gif/details";
    }

}
