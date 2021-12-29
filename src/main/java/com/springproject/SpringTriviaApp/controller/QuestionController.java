package com.springproject.SpringTriviaApp.controller;

import com.springproject.SpringTriviaApp.game.GameSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    @Autowired
    GameSession gameSession;

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String displayQuestion(ModelMap model, @RequestParam int turn){

        if(turn > 1) gameSession.endTurn();

        model.put("category", gameSession.getQuestionCategory());
        model.put("difficulty", gameSession.getQuestionDifficulty());
        model.put("question", gameSession.getQuestion());
        model.put("answers", gameSession.getAnswers());
        model.put("player", gameSession.getCurrentPlayerNickname());

        return "question";
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String submitAnswer(ModelMap model, @RequestParam String answer){
        String message;
        if(gameSession.isCorrectAnswer(answer)) {
            message = "Correct!!!";
            gameSession.addPoints();
        }
        else {
            message = "Incorrect. The correct answer was " + gameSession.getCorrectAnswer();
        }
        model.put("message", message);
        model.put("correct", gameSession.isCorrectAnswer(answer));
        model.put("answered", true);
        model.put("turn", gameSession.getCurrentTurn()+1);
        model.put("end", gameSession.isLastTurn());

        model.put("category", gameSession.getQuestionCategory());
        model.put("difficulty", gameSession.getQuestionDifficulty());
        model.put("question", gameSession.getQuestion());
        model.put("answers", gameSession.getAnswers());
        model.put("player", gameSession.getCurrentPlayerNickname());

        return "question";
    }


}
