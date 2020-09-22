package com.launchacademy.springpotluck.services;

import com.launchacademy.springpotluck.models.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class DishService {
  public List<Dish> dishes;
  public DishService(){
    dishes = new ArrayList<Dish>();
    Dish dish = new Dish();

    dish.setId(0);
    dish.setName("Tiana's Glorious Beignets");
    dish.setDescription("500 Man-catching beignets");
    dishes.add(dish);


    dish = new Dish();
    dish.setId(1);
    dish.setName("Iroh's White Dragon bush tea... or White Jade Bush tea...");
    dish.setDescription("Delectable tea? or deadly poison..?");
    dishes.add(dish);

    dish = new Dish();
    dish.setId(2);
    dish.setName("Muriel's Macaroni");
    dish.setDescription("MORE CHEESE!, less macaroni, LESS CHEESE!, MOAR MACARONI!!");
    dishes.add(dish);

    dish = new Dish();
    dish.setId(3);
    dish.setName("Mr. Ping's Noodle Soup");
    dish.setDescription("The secret ingredient... is that there is no secret ingredient!");
    dishes.add(dish);
  }

  public List<Dish> getList() {
    return dishes;
  }

  public void addToList(Dish dish) {
    dishes.add(dish);
  }
}
