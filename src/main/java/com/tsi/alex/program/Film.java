package com.tsi.alex.program;

import javax.persistence.*;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.lang.Nullable;
@Entity
@Table(name="film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;


}
