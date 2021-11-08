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

    public static CardTypeEnum getEnum(int type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.code == type)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public String getName() {
        return name;
    }
}
