package com.Banao.Authentication.controller;

import com.Banao.Authentication.model.Response;
import com.Banao.Authentication.model.product;
import com.Banao.Authentication.service.CategoryServ;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServ categoryServ;
    @GetMapping(value="/getCategory")
    private ResponseEntity<?> getCategory() throws Exception {
        System.out.println("inside getting category details controller");
        Response response=new Response();
        return categoryServ.getCategory();
    }

    @GetMapping(value="/getBrand")
    private ResponseEntity<?> getBrand(@RequestParam("categoryid") int categoryid) throws Exception {
        System.out.println("inside getting Brand details controller");
        Response response=new Response();
        return categoryServ.getBrand(categoryid);
    }
}
