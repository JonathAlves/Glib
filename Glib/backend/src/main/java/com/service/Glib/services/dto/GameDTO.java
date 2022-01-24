package com.service.Glib.services.dto;

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
    private Date release;
    private String developer;
    private String genre;
    private double evaluation;
    private String publisher;
    private List<PlatformDTO> platforms = new ArrayList<>();
}
