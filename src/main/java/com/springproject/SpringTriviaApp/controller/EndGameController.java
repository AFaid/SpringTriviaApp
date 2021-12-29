package com.springproject.SpringTriviaApp.controller;

import com.springproject.SpringTriviaApp.game.GameSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EndGameController {

    @Autowired
    GameSession gameSession;

    @RequestMapping(value = "/endGame", method = RequestMethod.GET)
    public String endGame(ModelMap model){
        model.put("winners", gameSession.findWinner());
        model.put("players", gameSession.getAllPlayers());
        return "endGame";
    }
}
