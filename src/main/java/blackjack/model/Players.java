package blackjack.model;

import java.util.List;

public class Players {

    List<Players> players;

    public Players(List<Players> players) {
        this.players = players;
    }


    public void getStart() {
        players.forEach(Players::getStart);
    }
}
