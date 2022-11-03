package com.taco.cloud.repo;

import com.taco.cloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
