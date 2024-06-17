package com.Banao.Authentication.service;

import com.Banao.Authentication.model.Image;
import com.Banao.Authentication.model.Response;
import com.Banao.Authentication.model.product;
import com.Banao.Authentication.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageServImpl implements ImageServ{

    private final ImageRepository imageRepository;

    @Override
    public ResponseEntity<?> getImagesByProductId(Integer id){
        Response response=new Response();
        System.out.println("inside getting images");
        List<Image> item=this.imageRepository.findByProduct(id);
        response=Response.ok().setMessage("Image found").setPayload(item);
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<?> getImageURLById(Integer id,String type){
        Response response=new Response();
        System.out.println("inside getting image URL");
        List<Image> item=null;
        if(type.equalsIgnoreCase("productId")){
            item=this.imageRepository.findByProduct(id);
        }
        else if(type.equalsIgnoreCase("imageId")){
            Optional<Image> image=this.imageRepository.findById(id);
            if(image.isPresent()){
                item= Arrays.asList(image.get());
            }
        }
        //response=Response.ok().setMessage("Image found").setPayload(item);
        return ResponseEntity.ok().body(item.get(0).getImagedata());
    }
}
