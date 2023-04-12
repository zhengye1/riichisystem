package com.vincent.riichisystem.game.entity;

import com.vincent.riichisystem.game.converter.UmaStringConverter;
import com.vincent.riichisystem.game.enumeration.GameType;
import com.vincent.riichisystem.game.enumeration.RiichiStickResolution;
import com.vincent.riichisystem.game.enumeration.TieBreaker;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Vincent Zheng
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GameRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String gameRuleName;

    @Column
    @Enumerated(EnumType.STRING)
    GameType gameType;

    @Column
    Integer startingScore;

    @Column
    Integer notenPenalty;

    @Column
    Integer honbaSize;
    
    @Column
    Integer oka;

    @Column
    @Enumerated(EnumType.STRING)
    TieBreaker tiebreaker;

    @Column(name = "uma_0_over")
    @Convert(converter = UmaStringConverter.class)
    List<Integer> uma0Over;

    @Column(name = "uma_1_over")
    @Convert(converter = UmaStringConverter.class)
    List<Integer> uma1Over;

    @Column(name = "uma_2_over")
    @Convert(converter = UmaStringConverter.class)
    List<Integer> uma2Over;

    @Column(name = "uma_3_over")
    @Convert(converter = UmaStringConverter.class)
    List<Integer> uma3Over;

    @Column
    Integer chomboPenalty;

    @Column
    boolean isKiriageManganEnable;

    @Column
    boolean isMultiRonEnable;

    @Column
    boolean isMultiYakumanEnable;

    @Column
    @Enumerated(EnumType.STRING)
    RiichiStickResolution riichiStickResolution;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    LocalDateTime updatedAt;

}
