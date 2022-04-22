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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_user")
    @SequenceGenerator(name = "sq_user", allocationSize = 1, sequenceName = "sq_user")
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "birth", nullable = false)
    private Date birth;
    @Column(name = "favoriteGames", nullable = false)
    private String favoriteGames;


}
