package com.service.Glib.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "release", nullable = false)
    private Date release;
    @Column(name = "developer", nullable = false)
    private String developer;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "evaluation")
    private double evaluation;
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Platform> platforms = new ArrayList<>();

}
