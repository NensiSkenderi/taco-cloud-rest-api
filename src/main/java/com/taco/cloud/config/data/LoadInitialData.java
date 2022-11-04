package com.taco.cloud.config.data;

import com.taco.cloud.model.Taco;
import com.taco.cloud.model.TacoIngredient;
import com.taco.cloud.repo.JpaTacoIngredientRepository;
import com.taco.cloud.repo.JpaTacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LoadInitialData {

    @Autowired
    private JpaTacoIngredientRepository tacoIngredientRepository;

    @Autowired
    private JpaTacoRepository tacoRepository;

    @PostConstruct
    private void postConstruct() {

        TacoIngredient ingredient1 = new TacoIngredient("1", "Feta Tortilla", TacoIngredient.Type.CHEESE);
        TacoIngredient ingredient2 = new TacoIngredient("2", "Corn Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient3 = new TacoIngredient("3", "Beans Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient4 = new TacoIngredient("4", "Lettuce Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient5 = new TacoIngredient("5", "Flour Tortilla", TacoIngredient.Type.WRAP);
        TacoIngredient ingredient6 = new TacoIngredient("6", "Tofu Tortilla", TacoIngredient.Type.PROTEIN);

        List<TacoIngredient> tacoIngredientList = new ArrayList<>();
        tacoIngredientList.add(ingredient1);
        tacoIngredientList.add(ingredient2);

        tacoIngredientRepository.saveAll(Arrays.asList(ingredient1, ingredient2, ingredient3, ingredient4,
                ingredient5, ingredient6));

        Taco taco1 = new Taco(1L, new Date(), "yfhgfh", tacoIngredientList);

        tacoRepository.save(taco1);
    }
}
