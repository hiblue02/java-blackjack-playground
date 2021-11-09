package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private static final int BLACK_JACK = 21 ;
    public List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }
    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public boolean isBust() {
        return getSum() > BLACK_JACK;
    }

    public int getSum(){
        return cards.stream().mapToInt(Card::getScore).sum();
    }

    public boolean isBlackjack(){
        return cards.size() == 2
                && cards.stream().allMatch(card -> card.isKQJ() || card.isAce());
    }
}
