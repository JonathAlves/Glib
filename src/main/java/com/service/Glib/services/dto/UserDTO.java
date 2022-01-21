package com.service.Glib.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDTO implements Serializable {
    private long idUser;
    private String nickname;
    private String email;
    private String password;
    private Date birth;
    private List<GameDTO> favoriteGames = new ArrayList<>();
}
