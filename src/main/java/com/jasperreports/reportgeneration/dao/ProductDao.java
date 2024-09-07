package com.jasperreports.reportgeneration.dao;

import com.jasperreports.reportgeneration.entities.Product;
import com.jasperreports.reportgeneration.repositories.ProductCrudRepository;
import com.jasperreports.reportgeneration.repositories.ProductJPARepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao implements IProductDao {

    private ProductCrudRepository productCrudRepository;

    private ProductJPARepository productJPARepository;


    public ProductDao (ProductCrudRepository productCrudRepository,ProductJPARepository productJPARepository) {
        this.productCrudRepository = productCrudRepository;
        this.productJPARepository = productJPARepository;
    }


    @Override
    public ArrayList<Product> getAllProductCrud() {
        return (ArrayList<Product>) productCrudRepository.findAll();
    }

    @Override
    public ArrayList<Product> getAllProductJPA() {
        return (ArrayList<Product>) productJPARepository.findAll();
    }
}
