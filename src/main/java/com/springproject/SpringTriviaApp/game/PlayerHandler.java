package com.springproject.SpringTriviaApp.game;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class PlayerHandler {

    private List<Player> players = new LinkedList<>();
    private int player_turn = 0;

    public List<Player> getPlayers() {
        return players;
    }

    public String getCurrentPlayerNickname(){
        return players.get(player_turn).getNickname();
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<String> findWinner() {
        List<String> winners = new ArrayList<>();
        int max_score = 0;

        for(Player player:players){
            if(player.getScore() > max_score){
                max_score = player.getScore();
                winners.clear();
                winners.add(player.getNickname());
            }
            else if(player.getScore() == max_score){
                winners.add(player.getNickname());
            }
        }
        return winners;
    }

    public void addPoints(int points) {
        this.players.get(player_turn).addPoints(points);
    }

    public void nextPlayer() {
        if (this.player_turn < this.players.size()-1) player_turn++;
        else player_turn = 0;
    }
}
