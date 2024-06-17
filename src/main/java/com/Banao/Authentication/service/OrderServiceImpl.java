package com.Banao.Authentication.service;

import com.Banao.Authentication.exception.CustomException;
import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.model.Order;
import com.Banao.Authentication.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class OrderServiceImpl implements OrderServ{

    @Autowired
    private OrderRepository orderRepository;


    public Order createorder(Order cart){
        return this.orderRepository.save((cart));
    }
    public Order orderbyid(int oid){
        Optional<Order> orderoptional=this.orderRepository.findById(oid);
        if(orderoptional.isPresent()){
            Order o=orderoptional.get();
            return o;
        }
        else
            throw new CustomException("No order found");
    }

    public Order addorder(List<Book> books,int oid){
        Optional<Order> orderoptional=this.orderRepository.findById(oid);

        if(orderoptional.isPresent()){
            Order o=orderoptional.get();
            Set<Book> s=new HashSet<>(books);
            for(Book b:books){
                o.getBooks().add(b);
            }
            return this.orderRepository.save(o);
        }

        else
            throw new CustomException("book or cart not found");
    }


}
