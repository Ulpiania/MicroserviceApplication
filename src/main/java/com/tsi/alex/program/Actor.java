package com.tsi.alex.program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Optional;

@Repository
@Entity
@Table(name ="actor")
public class Actor implements ActorRepository {
    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int actor_id;
    String first_name;
    String last_name;
    //Constructor's
    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Actor(){}
    //Methods
    public int getActor_id(){
        return actor_id;
    }

    public void setActor_id(int actor_id){
        this.actor_id = actor_id;
    }

    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Iterable saveAll(Iterable entities) {
        return null;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public Iterable findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void deleteAllById(Iterable iterable) {

    }

    @Override
    public void deleteAll(Iterable entities) {

    }

    @Override
    public void deleteAll() {

    }
}
