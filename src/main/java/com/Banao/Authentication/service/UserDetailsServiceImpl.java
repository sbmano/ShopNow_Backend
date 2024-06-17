package com.Banao.Authentication.service;

import com.Banao.Authentication.exception.CustomException;
import com.Banao.Authentication.model.Cart;
import com.Banao.Authentication.model.Role;
import com.Banao.Authentication.model.Users;
import com.Banao.Authentication.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.random.RandomGenerator;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService,UserDetailsServ {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public UserDetails loadUserByUsername(String s) throws CustomException {

        Optional<Users> user = Optional.ofNullable(this.userRepository.findByEmail(s));
                if(user.isPresent()){
                    Users u=user.get();
                    return new User(u.getEmail(),u.getPassword(),getAuthority(u));
                }
                else
                    throw new CustomException("User Not Found with username: " + s);

    }

    public Set<SimpleGrantedAuthority> getAuthority(Users user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return authorities;
    }

    public Users adduser(Users users){
        Role role = roleService.findbyname("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        users.setRoles(roleSet);
        users.setEnabled(false);
        String uuid1 = String.valueOf(UUID.randomUUID());
        users.setVerificationcode(uuid1);
        sendmail(users);
        return this.userRepository.save(users);
    }


    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Users> getalluser(){
        List<Users> list=this.userRepository.findAll();
        return list;
    }

    public Users getuserbyid(int id){
        Optional<Users> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else {
            throw new CustomException("user not found");
        }
    }

    public Users getuserbyemail(String s) {
        Optional<Users> user = Optional.ofNullable(this.userRepository.findByEmail(s));
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new CustomException("user not found");
        }
    }

    public void sendmail(Users users){
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(users.getEmail());
        msg.setSubject("Complete Registration");
        msg.setText("To confirm your account, please click here : "
                +"http://localhost:8080/api/auth/confirm-account?token="+users.getVerificationcode());
        javaMailSender.send(msg);
    }

    public boolean verifyaccount(String code){
        Users users=this.userRepository.findByVerificationcode(code);
        System.out.println("code  "+code);
        if(users==null||users.isEnabled())
            return false;
        else{
            users.setVerificationcode(null);
            users.setEnabled(true);
            this.userRepository.save(users);
            return true;
        }
    }


}

