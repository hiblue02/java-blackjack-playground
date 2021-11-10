package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return getScore() > BLACK_JACK;
    }

    public int getScore(){
        return cards.stream().mapToInt(Card::getScore).sum();
    }

    public boolean isBlackjack(){
        return cards.size() == 2
                && cards.stream().allMatch(card -> card.isKQJ() || card.isAce());
    }

    @Override
    public String toString() {
        return cards.stream().map(Card::toString).collect(Collectors.joining(","));
    }
}
