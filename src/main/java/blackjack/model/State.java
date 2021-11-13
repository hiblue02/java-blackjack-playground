package blackjack.model;

public interface State {

    State draw(Card card);
    State stay();
    boolean isFinished();
    Cards getCards();
    double profit(double betMoney);
}
