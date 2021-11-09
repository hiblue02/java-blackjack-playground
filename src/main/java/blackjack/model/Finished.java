package blackjack.model;

public abstract class Finished extends Started {


    private static final String CANNOT_DRAW_MESSAGE = "게임이 종료되어 카드를 뽑을 수 없습니다." ;
    private static final String CANNOT_STAY_MESSAGE = "게임이 종료되어 STAY할 수 업습니다." ;

    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        throw new IllegalArgumentException(CANNOT_DRAW_MESSAGE);
    }

    @Override
    public State stay() {
        throw new IllegalArgumentException(CANNOT_STAY_MESSAGE);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double profit) {
        return 1 * earningRate();
    }

    public abstract double earningRate();
}
