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

    @Column
    private String category_name;


    @Transient
    @Convert(converter = JsonNode.class)
    private JsonNode jsonNode;

    public Categories() {

    }

    public Categories(long category_id, String category_name, Set<Products> productsSet) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public long getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }


    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categories that)) return false;
        return category_id == that.category_id && Objects.equals(category_name, that.category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, category_name);
    }
}
