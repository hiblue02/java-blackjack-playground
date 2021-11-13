package blackjack.model;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }


    public void getStart() {
        this.players.forEach(Player::getStart);
    }

    public String getNames() {
        return players.stream().map(Player::getName).collect(Collectors.joining(","));
    }

    public String getCardList(){
        return players.stream().map(Player::toString).collect(Collectors.joining("\n"));
    }

    public void stay() {
        players.forEach(Player::stay);
    }
    public List<Player> getPlayers(){
        return this.players;
    }

    public String getReport(){
        return players.stream()
                .map(Player::getReport)
                .collect(Collectors.joining("\n"));
    }

    public String getProfitReport(){
       return players.stream()
                .map(Player::getProfitReport)
                .collect(Collectors.joining("\n"));
    }

    public void settleGameResult(){
        int min = players.stream().mapToInt(Player::abs).min().getAsInt();
        players.forEach(player -> player.winOrLoss(min));
    }

    public void setWinAll(){
        players.forEach(Player::win);
    }

}
