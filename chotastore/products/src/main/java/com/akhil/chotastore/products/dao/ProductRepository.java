package com.akhil.chotastore.products.dao;

import com.akhil.chotastore.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Integer> {
}
