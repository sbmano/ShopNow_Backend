package com.Banao.Authentication.service;

import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Order;

import java.util.List;

public interface OrderServ {

    public Order createorder(Order order);
    public Order orderbyid(int id);

    public Order addorder(List<Book> books, int oid);
}
