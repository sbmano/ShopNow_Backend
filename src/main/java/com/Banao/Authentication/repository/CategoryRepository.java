package com.Banao.Authentication.repository;

import com.Banao.Authentication.dto.BrandDTO;
import com.Banao.Authentication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Transactional(readOnly = true,isolation = Isolation.READ_UNCOMMITTED)
    @Query(value = "select id,brandname,categoryid from Brand where categoryid=:categoryid",nativeQuery = true)
    List<BrandDTO> getBrandbyCategoryid(@Param("categoryid") int categoryid);
}
