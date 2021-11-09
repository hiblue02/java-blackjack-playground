package blackjack.model;

public abstract class Started implements State {

    public Cards cards;

    public Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards getCards() {
        return this.cards;
    }
}
