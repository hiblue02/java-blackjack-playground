package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private static final int BLACK_JACK = 21;
    public String name;
    public Cards cards;

    public Person(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }
    public Person(String name) {
        this.name = name;
        this.cards = new Cards();
    }

    public String getName() {
        return this.name;
    }

    public void draw(Card card){
        this.cards.add(card);
    }

    public void draw(){
        this.cards.add(new Card());
    }

    public void getStart(){
        this.draw();
        this.draw();
    }

    public boolean isBlackJack(){
       return this.cards.isBlackjack();
    }
}
