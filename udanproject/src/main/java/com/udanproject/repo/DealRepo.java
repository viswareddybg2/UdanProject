package com.udanproject.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udanproject.entity.Deal;

@Repository
public interface DealRepo extends CrudRepository<Deal, Integer> {

}
