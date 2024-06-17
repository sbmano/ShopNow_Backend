package com.Banao.Authentication.repository;

import com.Banao.Authentication.model.Book;
import com.Banao.Authentication.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    @Query(value="select * from cart r where r.user_id=?1",nativeQuery=true)
    Cart findCartByUserId(int uid);

    //List<Book> findBookByCartId(int uid);
}
