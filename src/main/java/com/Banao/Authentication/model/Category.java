package com.Banao.Authentication.model;

import jakarta.persistence.*;
import lombok.*;

@Entity()
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="categoryname")
    private String categoryName;

    @Column(name="isactive")
    private Integer IsActive;

    @Column(name="parentid")
    private Integer parentId;
}
