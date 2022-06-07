package com.tsi.alex.program;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Repository
@Table(name="actor")
public class Actor implements ActorRepository{

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    //Attributes
    private String first_name;
    private String last_name;

    public Actor(String first_name, String last_name){
        this.first_name=first_name;
        this.last_name=last_name;
    }

    //Empty Constructor
    public Actor() {}

    //Getter and Setters

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void update(Actor newFirst_Name, Actor newLast_Name) {
        newFirst_Name.first_name = this.first_name;
        newLast_Name.last_name = this.last_name;

    }
    @Override
    public <S extends Actor> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Actor> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Actor> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Actor> findAll() {
        return null;
    }

    @Override
    public Iterable<Actor> findAllById(Iterable<Integer> integers) {
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
    public void delete(Actor entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Actor> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
