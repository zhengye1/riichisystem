package com.vincent.riichisystem.game.service;

import com.vincent.riichisystem.game.dto.GameRuleDTO;
import com.vincent.riichisystem.game.entity.GameRule;
import com.vincent.riichisystem.game.repository.GameRuleRespository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameRuleServiceTest {
    @InjectMocks
    private GameRuleService gameRuleService;

    @Mock
    private GameRuleRespository gameRuleRespository;

    @Test
    void returnAllGameRule() {
        when(gameRuleRespository.findAll()).thenReturn(List.of(new GameRule(), new GameRule()));

        assertThat(gameRuleService.returnAllGameRule()).hasSize(2);
        verify(gameRuleRespository, times(1)).findAll();
        verifyNoMoreInteractions(gameRuleRespository);
    }

    @Test
    void findGameRule() {
        final var expectedGameRule = new GameRule();
        expectedGameRule.setGameRuleName("JPML A-Rule");
        when(gameRuleRespository.findById(anyLong())).thenReturn(Optional.of(expectedGameRule));
        GameRuleDTO expectedGameRuleDTO = GameRuleDTO.builder().name("JPML A-Rule").build();
        final var actual = gameRuleService.findGameRule(getRandomLong());
        assertThat(actual).usingRecursiveComparison().isEqualTo(expectedGameRuleDTO);
        verify(gameRuleRespository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(gameRuleRespository);
    }

    @Test
    void findGameRuleNotExist() {
        when(gameRuleRespository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> gameRuleService.findGameRule(getRandomLong()));
        verify(gameRuleRespository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(gameRuleRespository);
    }

    @Test
    void saveNewGameRule() {
        final GameRuleDTO gameRuleToSave = GameRuleDTO.builder().name("JPML A Rule").build();
        final GameRule gameRule = GameRule.builder().gameRuleName("JPML A Rule").build();
        when(gameRuleRespository.save(any(GameRule.class))).thenReturn(gameRule);

        final var actual = gameRuleService.saveNewGameRule(GameRuleDTO.builder().build());
        assertThat(actual).usingRecursiveComparison().isEqualTo(gameRuleToSave);
        verify(gameRuleRespository, times(1)).save(any(GameRule.class));
        verifyNoMoreInteractions(gameRuleRespository);
    }

    private long getRandomLong() {
        return new Random().longs(1L, 10L).findFirst().orElse(0L);
    }
}