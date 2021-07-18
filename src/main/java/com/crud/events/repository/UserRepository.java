package com.crud.events.repository;

import com.crud.events.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    Set<User> findAll();
}
