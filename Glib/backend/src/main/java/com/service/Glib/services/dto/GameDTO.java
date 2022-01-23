package com.service.Glib.services.dto;

import com.service.Glib.entities.Platform;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GameDTO implements Serializable {
    private long idGame;
    private String name;
    private String synopsis;
    private Date releaseDate;
    private String developer;
    private String genre;
    private double evaluation;
    private String publisher;
    private List<Platform> platforms = new ArrayList<>();
}
