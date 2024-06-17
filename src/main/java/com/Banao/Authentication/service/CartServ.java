package com.Banao.Authentication.service;

import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.model.Users;

import java.util.List;

public interface CartServ {

    public Cart addtocart(Cart cart);

    public Cart addbooktocart(int cid,int bid);

    public Cart cartbyuserid(int id);

    public Cart cartbyid(int id);

    public List<Cart> getallcart();
}
