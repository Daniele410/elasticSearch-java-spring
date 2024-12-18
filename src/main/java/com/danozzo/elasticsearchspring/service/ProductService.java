package com.danozzo.elasticsearchspring.service;

import com.danozzo.elasticsearchspring.model.Product;
import com.danozzo.elasticsearchspring.model.ProductList;
import com.danozzo.elasticsearchspring.repository.ProductRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public Optional<Product> deleteProductById(String id){
        Optional<Product> product = productRepository.findById(id);
        productRepository.deleteById(id);
        return product;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Iterable<Product> saveProductsFromXml(String filePath) throws IOException {
        int MAX_PRODUCTS = 1000;
        XmlMapper xmlMapper = new XmlMapper();
        ProductList productList = xmlMapper.readValue(new File(filePath), ProductList.class);
        List<Product> allProducts = productList.getProduct();

        for (int i = 0; i < allProducts.size(); i++) {
         int end = Math.min(MAX_PRODUCTS, allProducts.size());
            List<Product> batch = allProducts.subList(i, end);

            batch.removeIf(product -> productRepository.existsById(product.getId()));

            productRepository.saveAll(batch);
        }

        return allProducts;
    }

    public Iterable<Product> saveProductsFromInputStream(InputStream inputStream) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        ProductList productList = xmlMapper.readValue(inputStream, ProductList.class);
        List<Product> products = productList.getProduct();

        products.removeIf(product -> productRepository.existsById(product.getId())); // remove existing products
        return productRepository.saveAll(products);
    }

}
