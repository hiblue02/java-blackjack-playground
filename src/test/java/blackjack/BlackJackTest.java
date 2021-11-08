package blackjack;

import blackjack.model.CardNumberEnum;
import blackjack.model.CardTypeEnum;
import blackjack.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BlackJackTest {

    @Test
    void setCard_one_hart(){
        Card card = new Card(CardNumberEnum.ONE, CardTypeEnum.HEART);
        assertEquals("1하트",card.toString());
    }
    @Test
    void setCard_K_spade(){
        Card card = new Card(CardNumberEnum.KING, CardTypeEnum.SPADE);
        assertEquals("K스페이드",card.toString());
    }
    @Test
    void getCardScore1(){
        Person jason = new Person("jason");
        jason.addCard(new Card(CardNumberEnum.SEVEN, CardTypeEnum.ClOVER));
        jason.addCard(new Card(CardNumberEnum.KING, CardTypeEnum.SPADE));
        assertEquals(17,jason.getScore());
    }
    @Test
    void getCardScore2(){
        Person jason = new Person("jason");
        jason.addCard(new Card(CardNumberEnum.TWO, CardTypeEnum.HEART));
        jason.addCard(new Card(CardNumberEnum.EIGHT, CardTypeEnum.SPADE));
        jason.addCard(new Card(CardNumberEnum.ACE, CardTypeEnum.ClOVER));
        assertEquals(21,jason.getScore());
    }
    @Test
    void getCardReport(){
        Person jason = new Person("jason");
        jason.addCard(new Card(CardNumberEnum.SEVEN, CardTypeEnum.ClOVER));
        jason.addCard(new Card(CardNumberEnum.KING, CardTypeEnum.SPADE));
        assertEquals("jason카드: 7클로버, K스페이드 - 결과: 17",jason.getReport());
    }
    @Test
    void isBlackJack(){
        Person jason = new Person("jason");
        jason.addCard(new Card(CardNumberEnum.TWO, CardTypeEnum.HEART));
        jason.addCard(new Card(CardNumberEnum.EIGHT, CardTypeEnum.SPADE));
        jason.addCard(new Card(CardNumberEnum.ACE, CardTypeEnum.ClOVER));
        assertTrue(jason.isBlackJack());
    }

}
