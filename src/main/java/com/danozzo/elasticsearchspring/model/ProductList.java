package com.danozzo.elasticsearchspring.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JacksonXmlRootElement(localName = "products")
@Getter
@Setter
@AllArgsConstructor
public class ProductList {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Product> product;

    // Getter e Setter
    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
