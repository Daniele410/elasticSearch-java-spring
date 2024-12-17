package com.danozzo.elasticsearchspring.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "products")
public class ProductList {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Product> product;

    public ProductList() {
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public ProductList(List<Product> product) {
        this.product = product;
    }
}
