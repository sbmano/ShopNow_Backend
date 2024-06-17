package com.Banao.Authentication.repository;

import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

   // @Query(value="select * from Book r where r.cart_id=?1",nativeQuery=true)
    List<Book> findBookByCartId(int uid);
    //List<Book> findBookByUserId(int uid);
}
