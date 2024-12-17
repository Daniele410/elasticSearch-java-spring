package com.danozzo.elasticsearchspring.service;

import com.danozzo.elasticsearchspring.model.Product;
import com.danozzo.elasticsearchspring.model.ProductList;
import com.danozzo.elasticsearchspring.repository.ProductRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductRepository getProductRepository() {
        return productRepository;
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

}
