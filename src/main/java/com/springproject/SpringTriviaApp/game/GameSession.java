package com.springproject.SpringTriviaApp.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameSession {

    private int number_of_turns = 0;
    private int current_turn = 0;

    @Autowired
    PlayerHandler playerHandler;

    @Autowired
    QuestionHandler questionHandler;

    public void startGameSession(List<Player> playerList){
        playerHandler.setPlayers(playerList);
        this.number_of_turns = playerList.size()*15;
        this.current_turn = 1;
    }

    public List<String> findWinner(){
        return playerHandler.findWinner();
    }

    public void endTurn(){
        playerHandler.nextPlayer();
        questionHandler.nextQuestion();
        this.current_turn++;
    }

    public int getCurrentTurn() {
        return current_turn;
    }

    private void endGame() {
        System.out.println("Game Ended!!!!\nWinner/s is/are " + findWinner());
    }

    public void addPoints(){
        String difficulty = questionHandler.getQuestionDifficulty();
        int points;

        if(difficulty.equals("easy")) points = 1;
        else if(difficulty.equals("medium")) points = 3;
        else points = 5;

        playerHandler.addPoints(points);
    }

    public String getCurrentPlayerNickname(){
        return playerHandler.getCurrentPlayerNickname();
    }

    public List<Player> getAllPlayers(){
        return playerHandler.getPlayers();
    }

    public String getQuestionCategory() {
        return questionHandler.getQuestionCategory();
    }

    public String getQuestionDifficulty() {
        return questionHandler.getQuestionDifficulty();
    }

    public String getQuestion() {
        return questionHandler.getQuestion();
    }

    public List<String> getAnswers() {
        return questionHandler.getQuestionAnswers();
    }

    public String getCorrectAnswer(){
        return questionHandler.getQuestionCorrectAnswer();
    }

    public boolean isCorrectAnswer(String answer){
        return questionHandler.isCorrectAnswer(answer);
    }

    public boolean isLastTurn() {
        return this.current_turn == this.number_of_turns;
    }
}
