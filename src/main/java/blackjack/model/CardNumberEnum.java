package blackjack.model;

import java.util.Arrays;

public enum CardNumberEnum {
    ACE(1,1, "1"),
    TWO(2,2,"2"),
    THREE(3,3,"3"),
    FOUR(4,4,"4"),
    FIVE(5,5,"5"),
    SIX(6,6, "6"),
    SEVEN(7,7, "7"),
    EIGHT(8,8,"8"),
    NINE(9,9, "9"),
    TEN(10,10,"10"),
    KING(12,10,"K"),
    QUEEN(13,10,"Q"),
    JACK(14,10,"J");

    private final int code;
    private final int score;
    private final String name;

    CardNumberEnum(int code, int score, String name) {
        this.code = code;
        this.score = score;
        this.name = name;
    }

    public static CardNumberEnum getEnum(int number) {
        return Arrays.stream(values()).filter(numberEnum -> numberEnum.code == number)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return name;
    }

    public boolean isAce() {
        return this == ACE;
    }
}
