package com.service.Glib.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlatformDTO implements Serializable {
    private long idPlatform;
    private String name;
}
