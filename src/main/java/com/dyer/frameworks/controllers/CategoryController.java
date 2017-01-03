package com.dyer.frameworks.controllers;

import com.dyer.frameworks.model.Category;
import com.dyer.frameworks.repository.CategoryRepository;
import com.dyer.frameworks.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple controller to handle requests for {@link Category}s.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String getAllCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryRepository.findAll());
        return "category-list";
    }

    @RequestMapping("/category/{id}")
    public String getCategoryById(@PathVariable int id, ModelMap modelMap) {
        modelMap.put("category", categoryRepository.findById(id));
        modelMap.put("gifs", gifRepository.findByCategoryId(id));
        return "category";
    }

}
