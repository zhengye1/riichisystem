package com.vincent.riichisystem.game.dto;

import com.vincent.riichisystem.game.enumeration.GameType;
import com.vincent.riichisystem.game.enumeration.RiichiStickResolution;
import com.vincent.riichisystem.game.enumeration.TieBreaker;
import lombok.Builder;
import lombok.Data;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

@Data
@SchemaMapping(typeName="GameRules")
@Builder
public class GameRuleDTO {
    Long id;
    String name;
    Integer startingScore;
    GameType gameType;
    TieBreaker tiebreaker;
    RiichiStickResolution riichiStickResolution;
    Integer notenPenalty;
    Integer honbaSize;
    Integer oka;
    List<Integer> uma0Over;
    List<Integer> uma1Over;
    List<Integer> uma2Over;
    List<Integer> uma3Over;
    Integer chomboPenalty;
    boolean kiriageMangan;
    boolean multiYakuman;
    boolean multiRon;
}
