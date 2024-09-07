package com.jasperreports.reportgeneration.services;

import com.jasperreports.reportgeneration.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Map<String, Object>> report();
    ArrayList<Product> getAllProduct();
}
