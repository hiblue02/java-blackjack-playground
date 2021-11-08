package blackjack.model;

public interface State {

    public State draw(Card card);
    public State stay();
    public boolean isFinished();
    public Cards cards();
    public double profit(double profit);

}
