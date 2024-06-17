package com.Banao.Authentication.service;

import com.Banao.Authentication.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ImageServ {

    ResponseEntity<?> getImagesByProductId(Integer id);
    ResponseEntity<?> getImageURLById(Integer id,String type);
}
