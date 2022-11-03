package com.taco.cloud.repo;

import com.taco.cloud.model.Order;
import com.taco.cloud.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaOrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}
