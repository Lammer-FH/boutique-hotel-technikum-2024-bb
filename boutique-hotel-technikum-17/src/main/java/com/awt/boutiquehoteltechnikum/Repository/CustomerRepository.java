package com.awt.boutiquehoteltechnikum.Repository;

import com.awt.boutiquehoteltechnikum.Entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
