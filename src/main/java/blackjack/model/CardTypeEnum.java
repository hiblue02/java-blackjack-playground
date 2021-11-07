package blackjack.model;

import java.util.Arrays;

public enum CardTypeEnum {
    HEART(1, "하트"),
    SPADE(2,"스페이드"),
    DIAMOND(3,"다이아몬드"),
    ClOVER(4,"클로버");

    private final int code;
    private final String name;

    CardTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CardTypeEnum getEnum(int code) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.code == code)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
