package blackjack.model;

public class Dealer extends Person{

    private static final int MIN_SCORE = 16;

    public Dealer() {
        super("딜러");
    }

    public boolean isUnder(){
        return super.getScore() <= MIN_SCORE;
    }

    public void addBenefit(int money) {
        super.benefit+=money;
    }
}
