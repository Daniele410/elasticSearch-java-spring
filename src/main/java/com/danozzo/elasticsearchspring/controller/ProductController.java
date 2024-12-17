package com.danozzo.elasticsearchspring.controller;

import com.danozzo.elasticsearchspring.model.Product;
import com.danozzo.elasticsearchspring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/upload-xml")
    public Iterable<Product> saveProductsFromXml(@RequestParam String filePath) throws IOException {
        return productService.saveProductsFromXml(filePath);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Product>>  deleteProduct(@PathVariable String id) {
      Optional<Product> product = productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("Custom-Header", "Value")
                .body(product);
    }

    @DeleteMapping
    public void deleteAllProducts() {
        productService.getProductRepository().deleteAll();
    }



}
