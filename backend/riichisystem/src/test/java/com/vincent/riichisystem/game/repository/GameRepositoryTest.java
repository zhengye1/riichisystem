package com.vincent.riichisystem.game.repository;

import com.vincent.riichisystem.game.entity.GameRule;
import com.vincent.riichisystem.game.enumeration.RiichiStickResolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.vincent.riichisystem.game.enumeration.GameType.YONMA;
import static com.vincent.riichisystem.game.enumeration.TieBreaker.DIVIDE_EQUALLY;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GameRepositoryTest {
    @Autowired
    GameRuleRespository gameRuleRespository;

    GameRule gameRule;

    GameRule wrcRule;

    @BeforeEach
    public void setup() {
        gameRule = new GameRule();
        gameRule.setGameRuleName("JPML A Rule");
        gameRule.setGameType(YONMA);
        gameRule.setChomboPenalty(-20);
        gameRule.setHonbaSize(300);
        gameRule.setNotenPenalty(3000);
        gameRule.setKiriageManganEnable(false);
        gameRule.setOka(0);
        gameRule.setStartingScore(30000);
        gameRule.setMultiRonEnable(false);
        gameRule.setMultiYakumanEnable(true);
        gameRule.setRiichiStickResolution(RiichiStickResolution.LOST_FOREVER);
        gameRule.setTieBreaker(DIVIDE_EQUALLY);
        gameRule.setUma0Over(Arrays.asList(8, 4, -4, -8));
        gameRule.setUma1Over(Arrays.asList(12, -1, -3, -8));
        gameRule.setUma2Over(Arrays.asList(8, 4, -4, -8));
        gameRule.setUma3Over(Arrays.asList(8, 3, 1, -12));

        wrcRule = new GameRule();
        wrcRule.setGameRuleName("WRC Rule");
        wrcRule.setGameType(YONMA);
        wrcRule.setChomboPenalty(-30);
        wrcRule.setHonbaSize(300);
        wrcRule.setNotenPenalty(3000);
        wrcRule.setOka(0);
        wrcRule.setKiriageManganEnable(true);
        wrcRule.setStartingScore(30000);
        wrcRule.setMultiRonEnable(false);
        wrcRule.setMultiYakumanEnable(true);
        wrcRule.setRiichiStickResolution(RiichiStickResolution.LOST_FOREVER);
        wrcRule.setTieBreaker(DIVIDE_EQUALLY);
        wrcRule.setUma0Over(Arrays.asList(15, 5, -5, -15));

    }

    @Test
    public void testSaveGameRule() {
        //given
        GameRule gameRule = new GameRule();
        gameRule.setGameRuleName("WRC Rule");
        gameRule.setGameType(YONMA);
        gameRule.setChomboPenalty(-30);
        gameRule.setHonbaSize(300);
        gameRule.setNotenPenalty(3000);
        gameRule.setKiriageManganEnable(true);
        gameRule.setStartingScore(30000);
        gameRule.setMultiRonEnable(false);
        gameRule.setMultiYakumanEnable(true);
        gameRule.setRiichiStickResolution(RiichiStickResolution.LOST_FOREVER);
        gameRule.setTieBreaker(DIVIDE_EQUALLY);
        gameRule.setUma0Over(Arrays.asList(15, 5, -5, -15));

        GameRule saveGameRule = gameRuleRespository.save(gameRule);
        assertThat(saveGameRule).isNotNull();
        assertThat(saveGameRule.getId()).isGreaterThan(0);

    }

    @Test
    public void testRetrieveAllGameRule() {
        gameRuleRespository.save(gameRule);
        gameRuleRespository.save(wrcRule);

        List<GameRule> gameRules = gameRuleRespository.findAll();

        assertThat(gameRules).isNotNull();
        assertThat(gameRules.size()).isEqualTo(2);

    }

    @Test
    public void testGatGameRuleById() {
        gameRuleRespository.save(wrcRule);
        GameRule gameRuleDB = gameRuleRespository.findById(wrcRule.getId()).orElse(null);
        assertThat(gameRuleDB).isNotNull();
        assertThat(gameRuleDB.getGameType()).isEqualTo(YONMA);
        assertThat(gameRuleDB.getGameRuleName()).isEqualTo("WRC Rule");
        assertThat(gameRuleDB.getNotenPenalty()).isEqualTo(3000);
        assertThat(gameRuleDB.getStartingScore()).isEqualTo(30000);
        assertThat(gameRuleDB.getHonbaSize()).isEqualTo(300);
        assertThat(gameRuleDB.isKiriageManganEnable()).isTrue();
        assertThat(gameRuleDB.isMultiYakumanEnable()).isTrue();
        assertThat(gameRuleDB.isMultiRonEnable()).isFalse();
        assertThat(gameRuleDB.getRiichiStickResolution()).isEqualTo(RiichiStickResolution.LOST_FOREVER);
        assertThat(gameRuleDB.getTieBreaker()).isEqualTo(DIVIDE_EQUALLY);
        assertThat(gameRuleDB.getChomboPenalty()).isEqualTo(-30);
        assertThat(gameRuleDB.getUma0Over()).contains(15, 5, -5, -15);
        assertThat(gameRuleDB.getUma1Over()).isNull();
        assertThat(gameRuleDB.getUma2Over()).isNull();
        assertThat(gameRuleDB.getUma3Over()).isNull();
        assertThat(gameRuleDB.getOka()).isEqualTo(0);
    }

}
