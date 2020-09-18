package com.lsantos.base.repository;

import com.lsantos.base.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
}
