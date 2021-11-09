package blackjack.model;

public interface State {

    public State draw(Card card);
    public State stay();
    public boolean isFinished();
    public Cards getCards();
    public double profit(double profit);

}
