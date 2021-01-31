package com.hcl.capstone.service;

import com.hcl.capstone.dao.ProductDao;
import com.hcl.capstone.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public boolean createProduct(String name, String category, String condition, double price, String imageLink) {
        try {
            productDao.save(new Product(name, category, condition, price, imageLink));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean updateProduct(String name, String category, String condition, double price, String imageLink) {
        try {
            productDao.deleteById(name);
            Product product = new Product(name, category, condition, price, imageLink);
            productDao.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Product getProduct(String name) {
        if (productDao.findById(name).isPresent()) return productDao.findById(name).get();
        return null;
    }

    public List<Product> getAllProducts() {
        return (ArrayList<Product>) productDao.findAll();
    }

    public void deleteProduct(String name) {
        productDao.deleteById(name);
    }
}
