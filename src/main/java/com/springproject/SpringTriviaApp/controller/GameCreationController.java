package com.springproject.SpringTriviaApp.controller;

import com.springproject.SpringTriviaApp.game.GameSession;
import com.springproject.SpringTriviaApp.game.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GameCreationController {

    @Autowired
    GameSession gameSession;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RedirectView startGame(ModelMap model, @RequestParam Map<String, String> allParams){
        List<Player> playerList = new ArrayList<>();
        for(String player_nickname:allParams.keySet()){
            playerList.add(new Player(allParams.get(player_nickname), 0));
        }

        gameSession.startGameSession(playerList);

        return new RedirectView("/question?turn="+gameSession.getCurrentTurn());
    }

}
