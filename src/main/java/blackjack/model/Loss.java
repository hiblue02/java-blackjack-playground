package blackjack.model;

public class Loss extends Finished{

    public Loss(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return -1.0;
    }
}
