package org.example.week06.sb_crud_webui.repository;

import org.example.week06.sb_crud_webui.domain.Game;

import java.util.List;

public interface GameRepository{
    Game save(Game game);

    List<Game> findAll();

    Game findById(Long id);

    Game update(Game game);

    void deleteById(Long id);
}
