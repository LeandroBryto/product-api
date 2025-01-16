package com.example.API_Restful.controller;

import com.example.API_Restful.model.ProductModel;
import com.example.API_Restful.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Product", description = "Endpoints para gerenciamento de produtos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista de todos os produtos cadastrados")
    @GetMapping("/product")
    public List<ProductModel> getALLProductModel() {
        return productService.getALLProductsModel();
    }

    @Operation(summary = "Obter produto por ID", description = "Retorna um produto específico com base no ID fornecido")
    @GetMapping("/{id}")
    public ProductModel getProductById(
            @Parameter(description = "ID do produto a ser encontrado", required = true)
            @PathVariable Long id) {
        ProductModel productModel = productService.getProductModelById(id);
        if (productModel == null){
            throw new EntityNotFoundException("Usuário com ID " + id + "não encontrado")  ;
        }
        return productModel;
    }

    @Operation(summary = "Salvar novo produto", description = "Cria um novo produto com os dados fornecidos")
    @PostMapping("/products")
    public ProductModel saveProduct(
            @Parameter(description = "Informações do produto a ser salvo", required = true)
            @RequestBody ProductModel productModel) {
        if (productModel.getNome() == null || productModel.getNome().isEmpty()){
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }
        if (productModel.getPrice() == null || productModel.getPrice() <= 0){
            throw new IllegalArgumentException("O preço deve ser maior que zero.") ;
        }
        return productService.saveProductModel(productModel);
    }

    @Operation(summary = "Atualizar produto", description = "Atualiza um produto existente com base no ID fornecido")
    @PutMapping("/{id}")
    public ProductModel updateProductModel(
            @Parameter(description = "ID do produto a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Dados atualizados do produto", required = true)
            @RequestBody ProductModel productModel) {
        if (productModel.getNome() == null || productModel.getNome().isEmpty()){
            throw new IllegalArgumentException("O nome do usuário é obrigatório");
        }
        if (productModel.getPrice() == null || productModel.getPrice() <= 0){
            throw new IllegalArgumentException("O preço dever ser maior que zero.");
        }
        productModel.setId(id);
        return productService.saveProductModel(productModel);
    }

    @Operation(summary = "Deletar produto", description = "Exclui um produto com base no ID fornecido")
    @DeleteMapping("/{id}")
    public void deleteProductModel(
            @Parameter(description = "ID do produto a ser excluído", required = true)
            @PathVariable Long id) {
        productService.deleteProductModel(id);
    }
}
