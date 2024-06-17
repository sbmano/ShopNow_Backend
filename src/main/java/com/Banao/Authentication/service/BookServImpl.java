package com.Banao.Authentication.service;

import com.Banao.Authentication.exception.CustomException;
import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.model.Users;
import com.Banao.Authentication.repository.BookRepository;
import com.Banao.Authentication.repository.CartRepository;
import com.Banao.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServImpl implements BookServ{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public Book addbook(Book book){
        System.out.println(book.getName());
        System.out.println(book.getPrice());
        return this.bookRepository.save(book);
    }

    public List<Book> bookbycartid(int cid){
        Optional<Cart> cartOptional=this.cartRepository.findById(cid);
        if(!cartOptional.isPresent()){
            throw new CustomException("cart id not found");
        }

        List<Book> books=this.bookRepository.findBookByCartId(cid);
        return books;
//            Optional<List<Book>> c= Optional.ofNullable(this.bookRepository.findbookbycartid(cid));
//            if(c.isPresent()){
//                List<Book> ca=c.get();
//                //System.out.println(ca.getBooks());
//                return ca;
//            }
//            else
//                throw new CustomException("cart not found for user");
//        }
//
//        else
//            throw new CustomException("cart id not found");
    }

//    public List<Book> bookbyuserid(int uid){
//        Optional<Users> usersOptional=this.userRepository.findById(uid);
//        if(!usersOptional.isPresent()){
//            throw new CustomException("cart id not found");
//        }
//
//       // List<Book> books=this.bookRepository.findBookByUserId(uid);
//        return books;
//    }
}
