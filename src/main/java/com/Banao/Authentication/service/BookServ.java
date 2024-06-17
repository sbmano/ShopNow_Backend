package com.Banao.Authentication.service;

import com.Banao.Authentication.model.Book;

import java.util.List;

public interface BookServ {


    public Book addbook(Book book);

    public List<Book> bookbycartid(int id);

    //public List<Book> bookbyuserid(int id);
}
