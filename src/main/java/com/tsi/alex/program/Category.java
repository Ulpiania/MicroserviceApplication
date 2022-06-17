package com.tsi.alex.program;


import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;
    String name;

    public Category(String name) {
        this.name = name;
    }
    //Empty constructor
    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(Category newName) {
        newName.name = this.name;
    }

}
