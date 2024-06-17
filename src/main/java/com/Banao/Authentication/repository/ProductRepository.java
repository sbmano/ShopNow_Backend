package com.Banao.Authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Banao.Authentication.model.product;
public interface ProductRepository extends JpaRepository<product,Integer>{
    
}
