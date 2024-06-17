package com.Banao.Authentication.controller;

import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.model.Order;
import com.Banao.Authentication.service.OrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class Ordercontroller {

    @Autowired
    private OrderServ orderServ;

    @PostMapping("/createorder")
    private ResponseEntity<Order> addtocart(@RequestBody Order order){
        return ResponseEntity.ok().body(this.orderServ.createorder(order));
    }
    @GetMapping("/getorderbyid/{oid}")
    private ResponseEntity<Order> getorderbyid(@PathVariable int oid){
        return ResponseEntity.ok().body(this.orderServ.orderbyid(oid));
    }

    @PostMapping("/addorder/{oid}")
    private ResponseEntity<Order> addorder(@RequestBody List<Book> books,@PathVariable int oid){
        return ResponseEntity.ok().body(this.orderServ.addorder(books,oid));
    }


}
