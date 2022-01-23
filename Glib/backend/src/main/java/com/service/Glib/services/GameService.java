package com.service.Glib.services;

import com.service.Glib.entities.Game;
import com.service.Glib.repositories.IGameRepository;
import com.service.Glib.services.dto.GameDTO;
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
public class GameService {

    @Autowired
    private IGameRepository gameRepository;
    @Autowired
    private ModelMapper modelMapper;


    //Listar todos os games
    public List<GameDTO> getGames(){
        List<Game> games = gameRepository.findAll();
        return toDtoList(games);
    }

    //Buscar game por ID
    public GameDTO getGame(long id) throws Exception{
        Game game = gameRepository.findById(id).orElseThrow(() -> new Exception("Game não encontrado!"));
        return toDto(game);
    }

    //Cadastrar um game
    public GameDTO createGame(GameDTO gameDTO){
        Game game = toEntity(gameDTO);
        gameRepository.save(game);
        return toDto(game);
    }

    //Editar um game
    public GameDTO editGame(GameDTO gameDTO){
        Game game = toEntity(gameDTO);
        gameRepository.save(game);
        return toDto(game);
    }

    //Deletar um game
    public void deleteGame(long id) throws Exception{
        gameRepository.findById(id).orElseThrow(() -> new Exception("Game não encontrado!"));
        gameRepository.deleteById(id);
    }

    //Conversão para DTO
    public GameDTO toDto(Game game){
        GameDTO gameDTO = modelMapper.map(game, GameDTO.class);
        return gameDTO;
    }
    //Conversão para DTO List
    public List<GameDTO> toDtoList(List<Game> games){
        List<GameDTO> gamesDTO = new ArrayList<>();
        for(Game game : games){
            GameDTO gameDTO = modelMapper.map(game, GameDTO.class);
            gamesDTO.add(gameDTO);
        }
        return gamesDTO;
    }

    //Conversão para Entity
    public Game toEntity(GameDTO gameDTO){
        Game game = modelMapper.map(gameDTO, Game.class);
        return game;
    }
    //Conversão para Entity List
    public List<Game> toEntityList(List<GameDTO> gamesDTO){
        List<Game> games = new ArrayList<>();
        for(GameDTO gameDTO : gamesDTO){
            Game game = modelMapper.map(gameDTO, Game.class);
            games.add(game);
        }
        return games;
    }

}
