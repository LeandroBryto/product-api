package com.example.API_Restful.service;

import com.example.API_Restful.model.ProductModel;
import com.example.API_Restful.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<ProductModel> getALLProductsModel(){
    return productRepository.findAll();
    }
    public ProductModel getProductModelById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public ProductModel saveProductModel(ProductModel productModel){
        return productRepository.save(productModel);
    }
    public void deleteProductModel(Long id){
        productRepository.deleteById(id);
    }
}
