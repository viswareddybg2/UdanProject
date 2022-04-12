package com.udanproject.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udanproject.entity.Items;

@Repository
public interface ItemsRepo extends CrudRepository<Items, Integer> {

}
