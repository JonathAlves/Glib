package com.service.Glib.services;

import com.service.Glib.entities.User;
import com.service.Glib.repositories.IUserRepository;
import com.service.Glib.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService{

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    //Listar todos os usuários
    public List<UserDTO> getUsers(){
        List<User> users = userRepository.findAll();
        return toDtoList(users);
    }

    //Buscar usuário por ID
    public UserDTO getUser(long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
        return toDto(user);
    }

    //Criar usuário
    public UserDTO createUser(UserDTO userDTO){
        User user = toEntity(userDTO);
        userRepository.save(user);
        return toDto(user);
    }

    //Editar usuário existente
    public UserDTO editUser(UserDTO userDTO){
        User user = toEntity(userDTO);
        userRepository.save(user);
        return toDto(user);
    }

    //Deleta um usuário
    public void deleteUser(long id) throws Exception{
        userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
        userRepository.deleteById(id);
    }

    public UserDTO toDto(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public List<UserDTO> toDtoList(List<User> users){
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user : users){
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    public User toEntity(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    public List<User> toEntityList(List<UserDTO> usersDTO){
        List<User> users = new ArrayList<>();
        for(UserDTO userDTO : usersDTO){
            User user = modelMapper.map(userDTO, User.class);
            users.add(user);
        }
        return users;
    }

}
