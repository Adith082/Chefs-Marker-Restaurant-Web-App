package com.deepseeker.ChefsMarker.service;

import com.deepseeker.ChefsMarker.entity.FoodItem;
import com.deepseeker.ChefsMarker.exception.InvalidException;
import com.deepseeker.ChefsMarker.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    void saveFoodItem(FoodItem foodItem) {
        foodItemRepository.save(foodItem);
    }

    List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    void updateFoodItem(FoodItem foodItem) throws InvalidException {
        try {
            FoodItem item = getFoodItemById(foodItem.getId());
            foodItemRepository.save(foodItem);
        } catch (InvalidException e) {
            throw e;
        }
    }

    FoodItem getFoodItemById(UUID id) throws InvalidException {
        return foodItemRepository.findById(id).orElseThrow(() -> new InvalidException("Invalid: id " + id));
    }

    void deleteFoodItem(FoodItem foodItem) {
        foodItemRepository.delete(foodItem);
    }
}
