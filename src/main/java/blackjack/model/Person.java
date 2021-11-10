package blackjack.model;

public class Person {

    private static final int BLACK_JACK = 21;
    public String name;
    public State state;

    public Person(String name, Cards cards) {
        this.name = name;
    }
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void getStart(){

        Cards cards = new Cards();
        cards.add(new Card());
        cards.add(new Card());

        if(cards.isBlackjack()){
            this.state = new BlackJack(cards);
            return;
        }
       this.state = new Hit(cards);
    }

    public void hit(){
        this.state.draw(new Card());
    }

    public boolean isBlackJack() {
        return state.getCards().isBlackjack();
    }

    public boolean isBust() {
        return state.getCards().isBust();
    }

    public boolean isFinished() {
        return this.state.isFinished();
    }

    public void stay() {
        this.state.stay();
    }

    public double getScore(){
        return this.state.getCards().getScore();
    }
    @Override
    public String toString() {
        return name+"카드: "+this.state.getCards().toString();
    }
}
