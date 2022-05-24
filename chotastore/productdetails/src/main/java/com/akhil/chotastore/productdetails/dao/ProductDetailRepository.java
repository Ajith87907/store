package com.akhil.chotastore.productdetails.dao;

import com.akhil.chotastore.productdetails.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ProductDetailRepository extends JpaRepository<Product,Integer> {
}
