package com.Banao.Authentication.service;

import com.Banao.Authentication.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryServ {

    ResponseEntity<?> getCategory();
    ResponseEntity<?> getBrand(int categoryid);
}
