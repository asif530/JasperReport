package com.jasperreports.reportgeneration.services;


import com.jasperreports.reportgeneration.dao.IProductDao;
import com.jasperreports.reportgeneration.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    private IProductDao productDao;

    public ProductServiceImpl(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Map<String, Object>> report() {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
       /* for (Product product : productCrudRepository.findAll()) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", product.getId());
            item.put("name", product.getName());
            item.put("price", product.getPrice());
            item.put("quantity", product.getQuantity());
            item.put("categoryName", product.getCategoryName());
            result.add(item);
        }*/
        return result;
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return productDao.getAllProductJPA();
    }
}
