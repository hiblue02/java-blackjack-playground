package blackjack.model;

public abstract class Started implements State {

    public Cards cards;

    public Started(Cards cards) {
    }

    @Override
    public Cards cards() {
        return cards;
    }
}
