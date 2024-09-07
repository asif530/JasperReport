package com.jasperreports.reportgeneration.repositories;

import com.jasperreports.reportgeneration.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
}
