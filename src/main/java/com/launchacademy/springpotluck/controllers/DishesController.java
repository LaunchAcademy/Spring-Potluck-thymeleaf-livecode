package com.launchacademy.springpotluck.controllers;

import com.launchacademy.springpotluck.models.Dish;
import com.launchacademy.springpotluck.services.DishService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dishes")
public class DishesController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public String listDishes(Model model){
        model.addAttribute("dishes", dishService.getList());
        return "dishes/index";
    }

    @GetMapping("/{dishId}")
    public String getDish(@PathVariable Integer dishId, Model model){
        List<Dish> dishes = dishService.getList();
        Dish dish = dishes.get(dishId);
        model.addAttribute("dish", dish);
        return "dishes/show";
    }

    @GetMapping("/new")
    public String newDish(Model model){
        Dish dish = new Dish();
        model.addAttribute("dish", dish);
        return "dishes/new";
    }

    @PostMapping
    public String addDish(@ModelAttribute Dish dish, Model model){
        dish.setId(dishService.getList().size());
        dishService.addToList(dish);
        model.addAttribute(dish);
        return "redirect:/dishes";
    }
}
