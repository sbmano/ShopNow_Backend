package com.Banao.Authentication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity()
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL})
    @JoinTable(name = "cart_book",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    //@JsonManagedReference
    private Set<Book> books=new HashSet<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH})
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private Users user_id;




}
