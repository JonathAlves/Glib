package com.service.Glib.services.mapper;

import com.service.Glib.entities.User;
import com.service.Glib.services.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GameMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User>{
}
