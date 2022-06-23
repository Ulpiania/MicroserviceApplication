package com.tsi.alex.program;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor{

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="film_actor", joinColumns = {
            @JoinColumn(name="actor_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name="film_id", nullable = false)
    })
    Set<Film> films;

    //Getter and Setters
    public int getActor_id() {
        return actor_id;
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

    public String toString()
    {
        return first_name + " " + last_name;
    }

}
