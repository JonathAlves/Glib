package com.service.Glib.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @Column(name = "RELEASE", nullable = false)
    private Date releaseDate;
    @Column(name = "DEVELOPER", nullable = false)
    private String developer;
    @Column(name = "GENRE", nullable = false)
    private String genre;
    @Column(name = "EVALUATION")
    private double evaluation;
    @Column(name = "PUBLISHER", nullable = false)
    private String publisher;
    @ElementCollection
    private List<Platform> platforms = new ArrayList<>();

}
