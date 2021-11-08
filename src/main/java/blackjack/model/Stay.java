package blackjack.model;

public class Stay extends Finished {
    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1.0;
    }
}
