package com.service.Glib.services.mapper;

import com.service.Glib.entities.Game;
import com.service.Glib.services.dto.GameDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface GameMapper extends EntityMapper<GameDTO, Game> {
}
