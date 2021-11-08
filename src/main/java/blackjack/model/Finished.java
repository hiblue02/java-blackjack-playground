package blackjack.model;

public abstract class Finished extends Started {

    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double profit) {
        return 0;
    }

    public abstract double earningRate();
}
