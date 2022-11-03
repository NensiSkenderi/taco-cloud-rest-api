package com.taco.cloud.repo;

import com.taco.cloud.model.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JpaTacoRepository extends PagingAndSortingRepository<Taco, Long> {
}
