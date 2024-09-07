package com.jasperreports.reportgeneration.repositories;

import com.jasperreports.reportgeneration.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepository extends JpaRepository<Product ,Integer> {
}
