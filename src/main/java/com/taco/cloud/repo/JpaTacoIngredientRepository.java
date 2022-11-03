package com.taco.cloud.repo;

import com.taco.cloud.model.TacoIngredient;
import org.springframework.data.repository.CrudRepository;

public interface JpaTacoIngredientRepository extends CrudRepository<TacoIngredient, String> {
}
