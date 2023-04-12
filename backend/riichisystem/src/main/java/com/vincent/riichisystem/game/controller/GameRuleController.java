package com.vincent.riichisystem.game.controller;

import com.vincent.riichisystem.game.dto.GameRuleDTO;
import com.vincent.riichisystem.game.service.GameRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GameRuleController {
    @Autowired
    GameRuleService gameRuleService;

    @QueryMapping
    List<GameRuleDTO> allGameRules(){
        return gameRuleService.returnAllGameRule();
    }


}
