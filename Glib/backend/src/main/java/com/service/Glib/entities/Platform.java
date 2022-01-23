package com.service.Glib.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Platform implements Serializable {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name")
    private String name;
}
