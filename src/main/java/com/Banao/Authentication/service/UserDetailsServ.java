package com.Banao.Authentication.service;

import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.model.Users;

import java.util.List;
import java.util.Set;

public interface UserDetailsServ {

    public Users adduser(Users users);
    public List<Users> getalluser();
    public Users getuserbyid(int id);
    public Users getuserbyemail(String s);

    public boolean verifyaccount(String s);

  //  public Set<Cart> cartbyuserid(int id);

}
