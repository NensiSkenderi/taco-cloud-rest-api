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

        TacoIngredient ingredient7 = new TacoIngredient("7", "Feta Tortilla", TacoIngredient.Type.CHEESE);
        TacoIngredient ingredient8 = new TacoIngredient("8", "Corn Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient9 = new TacoIngredient("9", "Beans Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient10 = new TacoIngredient("10", "Lettuce Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient11 = new TacoIngredient("11", "Flour Tortilla", TacoIngredient.Type.WRAP);
        TacoIngredient ingredient12 = new TacoIngredient("12", "Tofu Tortilla", TacoIngredient.Type.PROTEIN);

        TacoIngredient ingredient13 = new TacoIngredient("13", "Feta Tortilla", TacoIngredient.Type.CHEESE);
        TacoIngredient ingredient14 = new TacoIngredient("14", "Corn Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient15 = new TacoIngredient("15", "Beans Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient16 = new TacoIngredient("16", "Lettuce Tortilla", TacoIngredient.Type.VEGGIES);
        TacoIngredient ingredient17 = new TacoIngredient("17", "Flour Tortilla", TacoIngredient.Type.WRAP);
        TacoIngredient ingredient18 = new TacoIngredient("18", "Tofu Tortilla", TacoIngredient.Type.PROTEIN);

        List<TacoIngredient> tacoIngredientList = new ArrayList<>();
        tacoIngredientList.add(ingredient1);
        tacoIngredientList.add(ingredient2);

        tacoIngredientRepository.saveAll(Arrays.asList(ingredient1, ingredient2, ingredient3, ingredient4,
                ingredient5, ingredient6, ingredient7, ingredient8, ingredient9,
                ingredient10, ingredient11, ingredient12, ingredient13, ingredient14,
                ingredient15, ingredient16, ingredient17, ingredient18));

        Taco taco1 = new Taco(1L, new Date(), "taco1", tacoIngredientList);
        Taco taco2 = new Taco(2L, new Date(), "taco2", tacoIngredientList);
        Taco taco3 = new Taco(3L, new Date(), "taco3", tacoIngredientList);
        Taco taco4 = new Taco(4L, new Date(), "taco4", tacoIngredientList);
        Taco taco5 = new Taco(5L, new Date(), "taco5", tacoIngredientList);

        tacoRepository.saveAll(Arrays.asList(taco1, taco2, taco3, taco4, taco5));
    }
}
