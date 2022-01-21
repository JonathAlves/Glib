package com.service.Glib.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "NICKNAME", unique = true, nullable = false)
    private String nickname;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "BIRTH", nullable = false)
    private Date birth;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Game> favoriteGames = new ArrayList<>();


}
