package com.service.Glib.services;

import com.service.Glib.entities.User;
import com.service.Glib.repositories.IUserRepository;
import com.service.Glib.services.dto.UserDTO;
import com.service.Glib.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    private UserMapper userMapper;

    //Listar todos os usuários
    public List<UserDTO> getUsers(){
        List<User> users = userRepository.findAll();
        return userMapper.toDto(users);
    }

    //Buscar usuário por ID
    public UserDTO getUser(long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
        return userMapper.toDto(user);
    }

    //Criar usuário
    public UserDTO createUser(UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    //Editar usuário existente
    public UserDTO editUser(UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    //Deleta um usuário
    public void deleteUser(long id) throws Exception{
        userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado!"));
        userRepository.deleteById(id);
    }
}
