package com.udanproject.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udanproject.entity.PurchaseHistory;

@Repository
public interface PurchaseHistoryRepo extends CrudRepository<PurchaseHistory, Integer> {

}
