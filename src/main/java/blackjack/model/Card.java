package blackjack.model;

public class Card {
    private static final int NUMBER_COUNT = 14;
    private static final int TYPE_COUNT = 4;
    CardNumberEnum number;
    CardTypeEnum type;

    public Card(int number, int type) {
        this.number = CardNumberEnum.getEnum(number);
        this.type = CardTypeEnum.getEnum(type);
    }


    public Card(CardNumberEnum number, CardTypeEnum type) {
        this.number = number;
        this.type = type;
    }

    public Card(){
        this((int) (Math.random()*(NUMBER_COUNT-1)+1), (int) (Math.random()*(TYPE_COUNT-1)+1));
    }

    @Override
    public String toString() {
        return number.toString()+type.toString();
    }

    public int getScore() {
        return this.number.getValue();
    }
}
