package com.danozzo.elasticsearchspring.repository;

import com.danozzo.elasticsearchspring.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
