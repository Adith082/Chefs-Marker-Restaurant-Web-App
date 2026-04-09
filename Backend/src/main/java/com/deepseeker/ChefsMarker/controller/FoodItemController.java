package com.deepseeker.ChefsMarker.controller;

import com.deepseeker.ChefsMarker.entity.FoodItem;
import com.deepseeker.ChefsMarker.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/food-item")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("/add")
    ResponseEntity<UUID> addFoodItem(@RequestBody FoodItem foodItem) {
        UUID id = foodItemService.saveFoodItem(foodItem); // change foodItem to foodItemEntity in the future
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
