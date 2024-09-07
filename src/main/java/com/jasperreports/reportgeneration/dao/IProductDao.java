package com.jasperreports.reportgeneration.dao;

import com.jasperreports.reportgeneration.entities.Product;

import java.util.ArrayList;

public interface IProductDao {
     ArrayList<Product> getAllProductCrud();
     ArrayList<Product> getAllProductJPA();
}
