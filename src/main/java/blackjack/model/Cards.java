package blackjack.model;

import java.util.List;

public class Cards {

    private static final int BLACK_JACK = 21 ;
    public List<Card> cards;

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
        return cards.size() == 2 && getSum() == BLACK_JACK;
    }
}
