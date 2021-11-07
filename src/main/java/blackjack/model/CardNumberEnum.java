package blackjack.model;

import java.util.Arrays;

public enum CardNumberEnum {
    ONE(1,1, "1"),
    TWO(2,2,"2"),
    THREE(3,3,"3"),
    FOUR(4,4,"4"),
    FIVE(5,5,"5"),
    SIX(6,6, "6"),
    SEVEN(7,7, "7"),
    EIGHT(8,8,"8"),
    NINE(9,9, "9"),
    TEN(10,10,"10"),
    ACE(11,11,"A"),
    KING(12,10,"K"),
    QUEEN(13,10,"Q"),
    JACK(14,10,"J");

    private final int code;
    private final int value;
    private final String name;

    CardNumberEnum(int code, int value, String name) {
        this.code = code;
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public static CardNumberEnum getEnum(int code) {
        return Arrays.stream(values()).filter(numberEnum -> numberEnum.code == code)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
