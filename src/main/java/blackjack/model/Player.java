package blackjack.model;

import java.util.List;

public class Player extends Person {

    private int betAmount;

    public Player(String name, Cards cards) {
        super(name, cards);
    }

    public Player(String name) {
        super(name);
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
}
