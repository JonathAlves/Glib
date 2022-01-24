package com.service.Glib.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Platform implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platform", nullable = false, unique = true)
    private long id;

    @Column(name = "name")
    private String name;
}
