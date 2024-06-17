package com.Banao.Authentication.repository;

import com.Banao.Authentication.model.Image;
import com.Banao.Authentication.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ImageRepository extends JpaRepository<Image,Integer> {

//    @Query(value="select imagedata from Images r where r.productid=?1",nativeQuery=true)
//    List<MultipartFile> findByProduct(Integer productid);

    @Query(value="select * from Images r where r.productid=?1",nativeQuery=true)
    List<Image> findByProduct(Integer productid);

    @Query(value="select id from Images r where r.productid=?1",nativeQuery=true)
    List<Integer> findImageidByProductid(Integer productid);

    Image findFirstByProductid(@Param("productid") Integer id);
}
