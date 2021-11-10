package blackjack.model;

public class Dealer extends Person{

    private static final int MIN_SCORE = 16;

    public Dealer() {
        super("딜러");
    }

    public boolean isLow(){
        return  this.getScore() <= MIN_SCORE;
    }

}
