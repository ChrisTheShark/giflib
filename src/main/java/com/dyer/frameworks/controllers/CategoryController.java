package com.dyer.frameworks.controllers;

import com.dyer.frameworks.model.Category;
import com.dyer.frameworks.model.Color;
import com.dyer.frameworks.model.FlashMessage;
import com.dyer.frameworks.service.CategoryService;
import com.dyer.frameworks.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Simple controller to handle requests for {@link Category}s.
 */
@Controller
public class CategoryController {

    private static final String CATEGORIES = "/categories";
    private static final String ADD_CATEGORY = "/categories/add";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GifService gifService;

    @RequestMapping(ADD_CATEGORY)
    public String formNewCategory(Model model) {
        if (!model.containsAttribute("category")) {
            model.addAttribute("category", new Category());
        }
        model.addAttribute("colors", Color.values());
        return "category/form";
    }

    @RequestMapping(CATEGORIES)
    public String getAllCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryService.getAllCategories());
        return "category/index";
    }

    @RequestMapping("/category/{id}")
    public String getCategoryById(@PathVariable Long id, ModelMap modelMap) {
        modelMap.put("category", categoryService.getCategoryById(id));
        //modelMap.put("gifs", gifRepository.findByCategoryId(id));
        return "category/details";
    }

    @RequestMapping(value = CATEGORIES, method = RequestMethod.POST)
    public String addCategory(@Valid Category category, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // Include validation errors upon redirect.
            redirectAttributes.addFlashAttribute("org.springframework.validation." +
                    "BindingResult.category", bindingResult);

            // Add Category if invalid object was received.
            redirectAttributes.addFlashAttribute("category", category);
            return "redirect:" + ADD_CATEGORY;
        }
        categoryService.addCategory(category);

        redirectAttributes.addFlashAttribute("flash",
                new FlashMessage(FlashMessage.Status.SUCCESS,
                        "Category added successfully!"));
        return "redirect:" + CATEGORIES;
    }

}
