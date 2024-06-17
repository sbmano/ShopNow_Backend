package com.Banao.Authentication.dto;

import com.Banao.Authentication.model.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDTO {

    private Integer id;

    private String category;

    private String brand;

    private String name;

    private Integer showInHomeScreen;

    private Integer isOffersApplicable;

    private BigDecimal price;

    private Integer quantity;

    private String description;

    private List<Integer> imageid;

    private Integer isactive;
}
