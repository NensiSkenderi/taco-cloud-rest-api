package com.taco.cloud.repo;

import com.taco.cloud.model.TacoIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JpaTacoIngredientRepository extends PagingAndSortingRepository<TacoIngredient, String> {
}
