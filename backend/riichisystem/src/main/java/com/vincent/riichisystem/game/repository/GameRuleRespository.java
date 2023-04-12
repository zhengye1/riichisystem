package com.vincent.riichisystem.game.repository;

import com.vincent.riichisystem.game.entity.GameRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRuleRespository extends JpaRepository<GameRule, Long> {
}
