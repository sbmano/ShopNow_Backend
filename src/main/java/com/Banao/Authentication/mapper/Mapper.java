package com.Banao.Authentication.mapper;

import com.Banao.Authentication.dto.ImageDTO;
import com.Banao.Authentication.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.Banao.Authentication.model.product;

@Slf4j
public class Mapper {

    public static List<ProductDTO> mapproductdetails(List<Object[]> objectList){
        List<ProductDTO> productDTOList=new ArrayList<>();
        if(objectList.size()>0){
            for(Object[] objectlist:objectList){
                List list= Arrays.asList(objectlist);
                ProductDTO productDTO=new ProductDTO();
                productDTO.setId((Integer) list.get(0));
                productDTO.setCategory((String) list.get(1));
                productDTO.setBrand((String) list.get(2));
                productDTO.setName((String) list.get(3));
                productDTO.setPrice((BigDecimal) list.get(4));
                productDTO.setQuantity((Integer) list.get(5));
                productDTO.setDescription((String) list.get(6));
                productDTO.setShowInHomeScreen((Integer) list.get(7));
                productDTO.setIsOffersApplicable((Integer) list.get(8));
                productDTO.setIsactive((Integer) list.get(9));
                productDTOList.add(productDTO);
            }
        }
        return productDTOList;
    }

    public static ProductDTO mapproductdetails(product product){
                ProductDTO productDTO=new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setCategory(String.valueOf(product.getCategoryid()));
                productDTO.setBrand(String.valueOf(product.getCategoryid()));
                productDTO.setName(product.getName());
                productDTO.setShowInHomeScreen(product.getShowInHomeScreen());
                productDTO.setIsOffersApplicable(product.getIsOffersApplicable());
                productDTO.setPrice(BigDecimal.valueOf(product.getPrice()));
                productDTO.setQuantity(product.getQuantity());
                productDTO.setDescription(product.getDescription());
                productDTO.setIsactive(product.getIsactive());

        return productDTO;
    }
    public static List<ImageDTO> mapImageDetials(List<Object[]> objectList){
        List<ImageDTO> imageDTOList=new ArrayList<>();
        if(objectList.size()>0){
            for(Object[] objectlist:objectList){
                List list= Arrays.asList(objectlist);
                ImageDTO imageDTO=new ImageDTO();
                imageDTO.setId((Integer) list.get(0));
                imageDTO.setProductid((Integer) list.get(1));
                imageDTOList.add(imageDTO);
            }
        }
        return imageDTOList;
    }
}
