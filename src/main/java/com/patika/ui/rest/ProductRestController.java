package com.patika.ui.rest;

import com.patika.entity.ProductEntity;
import com.patika.exception.ResourceNotFoundException;
import com.patika.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docker/v1")
@CrossOrigin
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    //Ekleme
    // http://localhost:8080/docker/v1/create/product
    @PostMapping("/create/product")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity productEntity){
        return ResponseEntity.ok(productRepository.save(productEntity));
    }

    //Select
    // http://localhost:8080/docker/v1/list/product
    @GetMapping("/list/product")
    public ResponseEntity<List<ProductEntity>> findAll(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    //Bulma
    // http://localhost:8080/docker/v1/find/product/1
    @GetMapping("/find/product/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable(name = "id") Long id){
        ProductEntity productEntity = productRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(id +" product id bulunamadı ")
                );
        return ResponseEntity.ok(productEntity);
    }

    //Silme
    // http://localhost:8080/docker/v1/delete/product/1
    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity<Void> deleteProductId(@PathVariable(name = "id") Long id){
        ProductEntity productEntity = productRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(id +" product id bulunamadı !!! ")
                );
        productRepository.delete(productEntity);
        return ResponseEntity.ok().build();
    }
}
