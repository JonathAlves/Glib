package com.service.Glib.resource;

import com.service.Glib.services.GameService;
import com.service.Glib.services.dto.GameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/glib/games")
@RequiredArgsConstructor
public class GameResource {

    @Autowired
    private final GameService gameService;


    @GetMapping
    public ResponseEntity<List<GameDTO>> getGames(){
        List<GameDTO> games = gameService.getGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getGame(@PathVariable long id) throws Exception{
        return ResponseEntity.ok(gameService.getGame(id));
    }

    @PostMapping
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO){
        GameDTO game = gameService.createGame(gameDTO);
        return ResponseEntity.created(URI.create("glib/games")).body(game);
    }

    @PutMapping
    public ResponseEntity<GameDTO> editGame(@RequestBody GameDTO gameDTO){
        GameDTO game = gameService.editGame(gameDTO);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable long id) throws Exception{
        gameService.deleteGame(id);
    }
}
