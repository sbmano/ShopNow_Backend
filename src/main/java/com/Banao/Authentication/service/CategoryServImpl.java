package com.Banao.Authentication.service;

import com.Banao.Authentication.dto.BrandDTO;
import com.Banao.Authentication.model.Response;
import com.Banao.Authentication.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryServImpl implements CategoryServ {


    private final CategoryRepository categoryRepository;


    @Override
    public ResponseEntity<?> getCategory() {
        Response response=new Response();
        System.out.println("inside getting category");
        response = Response.ok().setMessage("Data retrived successfully").setPayload(this.categoryRepository.findAll());
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<?> getBrand(int categoryid) {
        Response response=new Response();
        log.info("inside getting Brand");
        //List<?> brand=new ArrayList<>(this.categoryRepository.getBrandbyCategoryid(categoryid));
        //List<BrandDTO> brand= (List<BrandDTO>) this.categoryRepository.getBrandbyCategoryid();
        response = Response.ok().setMessage("Data retrived successfully").setPayload(this.categoryRepository.getBrandbyCategoryid(categoryid));
        return ResponseEntity.ok().body(response);
    }
}
