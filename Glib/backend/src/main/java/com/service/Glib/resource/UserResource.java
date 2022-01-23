package com.service.Glib.resource;

import com.service.Glib.services.UserService;
import com.service.Glib.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/glib/users")
@RequiredArgsConstructor
public class UserResource {

    @Autowired
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> list = userService.getUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long id) throws Exception{
       return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
            UserDTO user = userService.createUser(userDTO);
            return ResponseEntity.created(URI.create("/glib/users")).body(user);
    }

    @PutMapping
    public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.editUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) throws Exception{
        userService.deleteUser(id);
    }

}
