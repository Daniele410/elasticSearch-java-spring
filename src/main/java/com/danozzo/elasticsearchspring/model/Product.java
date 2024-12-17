package com.danozzo.elasticsearchspring.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "products")
public class Product {

    @Id
    @JacksonXmlProperty(localName = "id")
    private String id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "description")
    private String description;
    @JacksonXmlProperty(localName = "price")
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
