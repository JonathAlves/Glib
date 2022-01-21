package com.service.Glib.repositories;

import com.service.Glib.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Long> {
}
