package com.JoysToysApplication.JoysToysApplication.Entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories", schema = "public")
public class Categories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long category_id;

    @Column(name = "category_name")
    private String categoryName;


    @Transient
    @Convert(converter = JsonNode.class)
    private JsonNode jsonNode;

    public Categories() {

    }

    public Categories(long category_id, String categoryName, Set<Products> productsSet) {
        this.category_id = category_id;
        this.categoryName = categoryName;
    }

    public long getCategory_id() {
        return category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categories that)) return false;
        return getCategory_id() == that.getCategory_id() && Objects.equals(getCategoryName(), that.getCategoryName()) && Objects.equals(jsonNode, that.jsonNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory_id(), getCategoryName(), jsonNode);
    }

}
