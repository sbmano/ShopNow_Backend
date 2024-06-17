package com.Banao.Authentication.service;

import com.Banao.Authentication.model.product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductServ {

    ResponseEntity<?> saveItem(product product, MultipartFile[] images);

    ResponseEntity<?> getItem(product product) throws IOException;

    ResponseEntity<?> getSpecialDealProducts() throws IOException;
}
