package com.Banao.Authentication.controller;

import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.service.CartServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartServ cartServ;

    @PostMapping("/addtocart")
    private ResponseEntity<Cart> addtocart(@RequestBody Cart cart){
        return ResponseEntity.ok().body(this.cartServ.addtocart(cart));
    }

    @PostMapping("/cart/{cid}/book/{bid}")
    private ResponseEntity<Cart> addbooktocart(@PathVariable("cid") int cid, @PathVariable("bid") int bid){
        return ResponseEntity.ok().body(this.cartServ.addbooktocart(cid,bid));
    }

    @GetMapping("/getcartbyuid/{uid}")
    private ResponseEntity<Cart> getcartforuser(@PathVariable int uid){
        return ResponseEntity.ok().body(this.cartServ.cartbyuserid(uid));
    }

    @GetMapping("/getcartbyid/{id}")
    private ResponseEntity<Cart> getcartbyid(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.cartServ.cartbyid(id));
    }
    @GetMapping("/getallcart")
    private ResponseEntity<List<Cart>> getallcart(){
        return ResponseEntity.ok().body(this.cartServ.getallcart());
    }
}
