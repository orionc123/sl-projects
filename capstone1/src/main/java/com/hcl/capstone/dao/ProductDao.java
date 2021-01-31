package com.hcl.capstone.dao;

import com.hcl.capstone.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, String> {
}
