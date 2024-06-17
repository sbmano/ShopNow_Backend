package com.Banao.Authentication.controller;

import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.service.BookServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class BookContoller {

    @Autowired
    private BookServ bookServ;

    @PostMapping("/addbook")
    private ResponseEntity<Book> addbook(@RequestBody Book book){
        return ResponseEntity.ok().body(this.bookServ.addbook(book));
    }

    @GetMapping("/getbookbycartid/{id}")
    private ResponseEntity<List<Book>> getbookbycartid(@PathVariable("id") int id){
        return ResponseEntity.ok().body(this.bookServ.bookbycartid(id));
    }

//    @GetMapping("/getbookbyorderid/{id}")
//    private ResponseEntity<List<Book>> getbookbycartid(@PathVariable("id") int id){
//        return ResponseEntity.ok().body(this.bookServ.bookbycartid(id));
//    }




}
