package com.tsi.alex.program;

import javax.persistence.*;
import java.util.Optional;
@Entity
@Table(name="language")
public class Language implements LanguageRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int languageId;
    String name;

    public Language(String name){
        this.name = name;
    }

    public Language(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public <S extends Language> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Language> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Language> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Language> findAll() {
        return null;
    }

    @Override
    public Iterable<Language> findAllById(Iterable<Integer> integers) {
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
    public void delete(Language entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Language> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
