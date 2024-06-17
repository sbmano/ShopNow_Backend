package com.Banao.Authentication.controller;

import com.Banao.Authentication.model.Response;
import com.Banao.Authentication.model.product;
import com.Banao.Authentication.service.ImageServ;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImageController {

    private final ImageServ imageServ;

    @GetMapping(value="/getImagesbyProductId")
    private ResponseEntity<?> getProduct(@RequestParam(value="productid")  Integer productid) throws Exception {
        System.out.println("inside getting Image details controller");
        Response response=new Response();
        return imageServ.getImagesByProductId(productid);
    }

    @GetMapping(value="/getImagebyURL")
    private ResponseEntity<?> getImageURl(@RequestParam(value="id")  Integer productid,
                                          @RequestParam(value="idType")  String type) throws Exception {
        System.out.println("inside getting Image URL controller");
        return imageServ.getImageURLById(productid,type);
    }
}
