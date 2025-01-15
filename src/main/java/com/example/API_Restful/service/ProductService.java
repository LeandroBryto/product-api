package com.example.API_Restful.service;

import com.example.API_Restful.model.ProductModel;
import com.example.API_Restful.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return productRepository.findById(id).orElseThrow(() ->
              new  EntityNotFoundException("Usuário com ID " +  id + "não encontrado"));
    }
    public ProductModel saveProductModel(ProductModel productModel){
        if (productModel.getNome() == null || productModel.getNome().isEmpty()){
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }
        if (productModel.getPrice() == null || productModel.getPrice() <= 0){
            throw  new IllegalArgumentException("o preço  deve ser maior que zero.");
        }
        return productRepository.save(productModel);
    }
    public void deleteProductModel(Long id){
        productRepository.deleteById(id);
    }
}
