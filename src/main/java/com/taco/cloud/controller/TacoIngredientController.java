package com.taco.cloud.controller;

import com.taco.cloud.config.OrderConfigProperties;
import com.taco.cloud.model.TacoIngredient;
import com.taco.cloud.repo.JpaTacoIngredientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class TacoIngredientController {

    OrderConfigProperties orderConfigProperties;

    JpaTacoIngredientRepository tacoIngredientRepository;

    public TacoIngredientController(OrderConfigProperties orderConfigProperties, JpaTacoIngredientRepository tacoIngredientRepository) {
        this.orderConfigProperties = orderConfigProperties;
        this.tacoIngredientRepository = tacoIngredientRepository;
    }

    @GetMapping("/recent")
    private Iterable<TacoIngredient> getRecentAddedIngredients() {
        PageRequest pageRequest = PageRequest.of(1, orderConfigProperties.getPageSize(),
                Sort.by("id").descending());

        return tacoIngredientRepository.findAll(pageRequest).getContent();
    }
}
