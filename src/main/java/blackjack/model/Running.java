package blackjack.model;

public abstract class Running extends Started {

    public Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double betMoney) {
        throw new IllegalArgumentException("게임이 끝나지 않아 수익을 알 수 없습니다.");
    }
}
