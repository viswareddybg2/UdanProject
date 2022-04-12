package com.udanproject.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udanproject.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
