package com.tsi.alex.program;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Repository
@Table(name="category")
public class Category implements CategoryRepository {
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

    @Override
    public <S extends Category> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Category> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Category> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Category> findAll() {
        return null;
    }

    @Override
    public Iterable<Category> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Category entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Category> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
