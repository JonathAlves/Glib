package com.service.Glib.services;

import com.service.Glib.entities.Game;
import com.service.Glib.repositories.IGameRepository;
import com.service.Glib.services.dto.GameDTO;
import com.service.Glib.services.mapper.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class GameService {
    @Autowired
    private IGameRepository gameRepository;
    private GameMapper gameMapper;

    //Listar todos os games
    public List<GameDTO> getGames(){
        List<Game> games = gameRepository.findAll();
        return gameMapper.toDto(games);
    }

    //Buscar game por ID
    public GameDTO getGame(long id) throws Exception{
        Game game = gameRepository.findById(id).orElseThrow(() -> new Exception("Game não encontrado!"));
        return gameMapper.toDto(game);
    }

    //Cadastrar um game
    public GameDTO createGame(GameDTO gameDTO){
        Game game = gameMapper.toEntity(gameDTO);
        gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    //Editar um game
    public GameDTO editGame(GameDTO gameDTO){
        Game game = gameMapper.toEntity(gameDTO);
        gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    //Deletar um game
    public void deleteGame(long id) throws Exception{
        gameRepository.findById(id).orElseThrow(() -> new Exception("Game não encontrado!"));
        gameRepository.deleteById(id);
    }


}
