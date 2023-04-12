package com.vincent.riichisystem.game.service;

import com.vincent.riichisystem.game.dto.GameRuleDTO;
import com.vincent.riichisystem.game.entity.GameRule;
import com.vincent.riichisystem.game.repository.GameRuleRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vincent Zheng
 */
@Service
@Transactional
@Slf4j
public class GameRuleService {

    @Autowired
    GameRuleRespository gameRuleRespository;

    public List<GameRuleDTO> returnAllGameRule() {
        List<GameRule> gameRules = gameRuleRespository.findAll();
        return gameRules.stream().map(this::convertEntityToDTO).collect(Collectors.toList());

    }

    public GameRuleDTO findGameRule(Long id) {
        GameRule gameRule = gameRuleRespository.findById(id).orElseThrow(EntityNotFoundException::new);
        return convertEntityToDTO(gameRule);
    }

    public GameRuleDTO saveNewGameRule(GameRuleDTO gameRule) {
        GameRule newGameRule = convertDTOToEntity(gameRule);
        return convertEntityToDTO(gameRuleRespository.save(newGameRule));
    }

    private GameRuleDTO convertEntityToDTO(GameRule gameRule) {
        return GameRuleDTO.builder().id(gameRule.getId()).name(gameRule.getGameRuleName())
            .gameType(gameRule.getGameType()).startingScore(gameRule.getStartingScore())
            .tiebreaker(gameRule.getTiebreaker()).riichiStickResolution(gameRule.getRiichiStickResolution())
            .notenPenalty(gameRule.getNotenPenalty()).honbaSize(gameRule.getHonbaSize())
            .uma0Over(gameRule.getUma0Over()).uma1Over(gameRule.getUma1Over()).uma2Over(gameRule.getUma2Over())
            .uma3Over(gameRule.getUma3Over()).chomboPenalty(gameRule.getChomboPenalty())
            .kiriageMangan(gameRule.isKiriageManganEnable()).multiYakuman(gameRule.isMultiYakumanEnable())
            .multiRon(gameRule.isMultiRonEnable()).oka(gameRule.getOka()).build();
    }

    private GameRule convertDTOToEntity(GameRuleDTO gameRule) {
        return GameRule.builder().gameRuleName(gameRule.getName()).startingScore(gameRule.getStartingScore())
            .tiebreaker(gameRule.getTiebreaker()).riichiStickResolution(gameRule.getRiichiStickResolution())
            .gameType(gameRule.getGameType())
            .notenPenalty(gameRule.getNotenPenalty())
            .honbaSize(gameRule.getHonbaSize())
            .uma0Over(gameRule.getUma0Over())
            .uma1Over(gameRule.getUma1Over())
            .uma2Over(gameRule.getUma2Over())
            .uma3Over(gameRule.getUma3Over())
            .chomboPenalty(gameRule.getChomboPenalty())
            .isKiriageManganEnable(gameRule.isKiriageMangan())
            .isMultiRonEnable(gameRule.isMultiRon())
            .isMultiYakumanEnable(gameRule.isMultiYakuman()).build();

    }
}
