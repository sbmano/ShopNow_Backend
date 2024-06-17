package com.Banao.Authentication.service;

import com.Banao.Authentication.dto.ProductDTO;
import com.Banao.Authentication.jwt.JwtAuthenticationEntryPoint;
import com.Banao.Authentication.mapper.Mapper;
import com.Banao.Authentication.model.Image;
import com.Banao.Authentication.model.Response;
import com.Banao.Authentication.repository.ImageRepository;
import com.Banao.Authentication.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Banao.Authentication.model.product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServImpl implements ProductServ{
    private static final Logger logger = LoggerFactory.getLogger(ProductServImpl.class);

    private final ProductRepository productRepository;

    private final ImageRepository imageRepository;

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    @Override
    public ResponseEntity<?> saveItem(product product, MultipartFile[] images){
          Response response=new Response();
        System.out.println("inside saving product");
        product.setIsactive(1);
        this.productRepository.save(product);

        for (MultipartFile image : Arrays.asList(images)) {
            Image imgobj = new Image();
//            imgobj.setProduct(product);
            imgobj.setProductid(product.getId());
            System.out.println("product Id: "+product.getId());
            try {
                imgobj.setImagedata(image.getBytes());
                imageRepository.save(imgobj);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("inside catch block");
                response = Response.internalServerError().setMessage("Exception Occurred while saving data: " + e.getMessage());
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
        }

        response = Response.ok().setMessage("Data saved successfully");
        return ResponseEntity.ok().body(response);
    }


    @Override
    public ResponseEntity<?> getItem(product product) throws IOException {
        Response response=new Response();
        Optional<product> item=this.productRepository.findById(product.getId());
        if(item.isPresent()){
            ProductDTO productDTO= Mapper.mapproductdetails(item.get());
            List<Integer> images=this.imageRepository.findImageidByProductid(product.getId());
            logger.info("No of images found for Product: "+ images.size());
            productDTO.setImageid(images);

                //productdetail.setImage(images.);
           // System.out.println("image data: "+ images.get(0).getImagedata());
//                for (Image img:images) {
//                    System.out.println("inside getting image");
//                    Image imgobj=new Image();
//                    imgobj.setImagedata(img.getBytes());
//                    i.add(imgobj);
//                }

            System.out.println("after getting image");
            System.out.println(images);
            System.out.println("product detail: "+productDTO);
            response=Response.ok().setMessage("Record found").setPayload(productDTO);
            return ResponseEntity.ok().body(response);
        }
        else {
            response=Response.notfound().setMessage("Record Not found");
            return ResponseEntity.ok().body(response);
        }
    }


    @Override
    public ResponseEntity<?> getSpecialDealProducts() throws IOException {
        Response response=new Response();
        List<ProductDTO> productDTOList=new ArrayList<>();
        List<Object[]> productsList=(List<Object[]>) entityManager.createNativeQuery("select * from getspecialdealproducts();")
                .getResultList();
        productDTOList=Mapper.mapproductdetails(productsList);
        for(ProductDTO list:productDTOList){
                Image image=this.imageRepository.findFirstByProductid(list.getId());
                list.setImageid(Collections.singletonList(image.getId()));
        }
        Map<String,List<ProductDTO>> products=productDTOList.stream().collect(Collectors.groupingBy(ProductDTO::getCategory));
        response=Response.ok().setMessage("Data retrived successfully").setPayload(products);
        return ResponseEntity.ok().body(response);
    }

}
