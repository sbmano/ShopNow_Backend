package com.Banao.Authentication.controller;

import com.Banao.Authentication.model.Response;
import com.Banao.Authentication.model.product;
import com.Banao.Authentication.model.payloads.Login;
import com.Banao.Authentication.service.ProductServ;
import com.Banao.Authentication.service.ProductServImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    private final ProductServ productServ;

    @PostMapping(value="/saveProduct",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private ResponseEntity<?> saveProduct(@RequestPart(value="product") product product,@RequestParam("image") MultipartFile[] images) throws IOException {
    //private ResponseEntity<?> saveProduct(@RequestParam(value="product") product product,@RequestParam("image") MultipartFile[] images) throws IOException {
        logger.info("inside saving image controller");
        Response response=new Response();
        return productServ.saveItem(product,images);
    }

    @GetMapping(value="/getProductbyProductid")
    private ResponseEntity<?> getProduct(@RequestParam(value="productid") product product) throws Exception {
        logger.info("inside getting product details by productid controller");
        Response response=new Response();
        return productServ.getItem(product);
    }

    @GetMapping(value="/getSpecialDealProducts")
    private ResponseEntity<?> getSpecialDealProducts() throws Exception {
        logger.info("inside getting homescreen products controller");
        Response response=new Response();
        return productServ.getSpecialDealProducts();
    }

}
