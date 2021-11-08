package blackjack.model;

public class Card {

    private static final int NUMBER_COUNT = 14;
    private static final int TYPE_COUNT = 4;
    private final CardNumberEnum number;
    private final CardTypeEnum type;

    public Card(CardNumberEnum number, CardTypeEnum type) {
        this.number = number;
        this.type = type;
    }
    public Card(int number, int type) {
        this(CardNumberEnum.getEnum(number), CardTypeEnum.getEnum(type));
    }

    public Card() {
        this((int) (Math.random()*(NUMBER_COUNT-1)+1), (int) (Math.random()*(TYPE_COUNT-1)+1));
    }

    @Override
    public String toString() {
        return number.getName()+type.getName();
    }

    public boolean isAce(){
        return this.number.isAce();
    }

    public int getScore() {
        return this.number.getScore();
    }

}
