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


    public void winOrLoss(int min) {
        int abs = abs();
        if (abs == min) {
            this.win();
            return;
        }
       this.loss();
    }

    public void win() {
        this.state = new Win(state.getCards());
    }

    public void loss(){
        this.state = new Loss(state.getCards());
    }
}
