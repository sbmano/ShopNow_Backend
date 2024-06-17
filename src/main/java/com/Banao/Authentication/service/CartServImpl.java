package com.Banao.Authentication.service;

import com.Banao.Authentication.exception.CustomException;
import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.model.Users;
import com.Banao.Authentication.repository.BookRepository;
import com.Banao.Authentication.repository.CartRepository;
import com.Banao.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CartServImpl implements CartServ{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart addtocart(Cart cart){
        return this.cartRepository.save((cart));
        //Book book=this.bookRepository.findById(cart.setUser_id());
        //return this.cartRepository.save(cart);
    }

    public Cart addbooktocart(int cid,int bid){
        Optional<Cart> cartoptional=this.cartRepository.findById(cid);
        Optional<Book> bookoptional=this.bookRepository.findById(bid);
        if(cartoptional.isPresent()&&bookoptional.isPresent()){
            Cart c=cartoptional.get();
            Book b=bookoptional.get();
            c.getBooks().add(b);
            return this.cartRepository.save(c);
        }

        else
            throw new CustomException("book or cart not found");

    }

    public Cart cartbyuserid(int uid){
        Optional<Users> usersOptional=this.userRepository.findById(uid);
        if(usersOptional.isPresent()){
            Optional<Cart> c= Optional.ofNullable(this.cartRepository.findCartByUserId(uid));
                    if(c.isPresent()){
                        Cart ca=c.get();
                        System.out.println(ca.getBooks());
                        return ca;
                    }
                    else
                        throw new CustomException("cart not found for user");
        }

        else
            throw new CustomException("user not found");
    }

   public Cart cartbyid(int id){
        Optional<Cart> cartOptional=this.cartRepository.findById(id);
        if(cartOptional.isPresent()){
            Cart c=cartOptional.get();
            System.out.println("books" + c.getBooks());
            return c;
        }

        else
            throw new CustomException("cart not found");
   }

   public List<Cart> getallcart(){
        return this.cartRepository.findAll();
   }
}
