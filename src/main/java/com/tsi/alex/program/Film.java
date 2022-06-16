package com.tsi.alex.program;

import javax.persistence.*;
import java.util.Optional;

import org.springframework.lang.Nullable;
@Entity
@Table(name="film")
public class Film {

    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    String title;
    String description;
    int release_year;
    int language_id;

    @Nullable
    Integer original_language_id;

    int rental_duration;
    float rental_rate;
    int length;
    float replacement_cost;
    String rating;
    String special_features;

    public Film(String title, String description, int release_year, int language_id, Integer original_language_id, int rental_duration, float rental_rate, int length, float replacement_cost, String rating, String special_features){
            this.title = title;
            this.description = description;
            this.release_year = release_year;
            this.language_id =language_id;
            this.original_language_id = original_language_id;
            this.rental_duration = rental_duration;
            this.rental_rate = rental_rate;
            this.length = length;
            this.replacement_cost = replacement_cost;
            this.rating = rating;
            this.special_features = special_features;
    }

    public Film(){

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getRelease_year(){
        return release_year;
    }

    public void setRelease_year(int release_year){
        this.release_year = release_year;
    }

    public int getLanguage_id(){
        return language_id;
    }

    public void setLanguage_id(int language_id){
        this.language_id = language_id;
    }

    public Integer getOriginal_language_id(){
        return original_language_id;
    }

    public void setOriginal_language_id(Integer original_language_id){
        this.original_language_id = original_language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public float getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(float rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(float replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }
}
