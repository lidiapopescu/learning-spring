package com.training.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.training.postgresql.model.Product;

//@Repository  no need this annotation
public interface ProductRepository extends JpaRepository<Product, Long>{

}
