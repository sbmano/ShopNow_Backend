package com.Banao.Authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity()
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@ManyToOne(cascade = {CascadeType.MERGE, CascadeType. DETACH},fetch = FetchType.LAZY)
//    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
//    @JoinColumn(name="productid",referencedColumnName = "id")
//    @JsonIgnore
//    private product product;
    private Integer productid;

    private byte[] imagedata;
}
