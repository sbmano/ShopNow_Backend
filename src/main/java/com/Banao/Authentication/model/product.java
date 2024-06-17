package com.Banao.Authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity()
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer categoryid;

    private Integer brandid;

    private String name;

    @Column(name = "showinhomescreen")
    private int showInHomeScreen;

    @Column(name = "isoffersapplicable")
    private int isOffersApplicable;

    private double price;

    private int quantity;

    private String description;

//    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Image> image;

    private int isactive;
}
