package blackjack;

import blackjack.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BlackJackTest {

    @Test
    void setCard_one_hart(){
        Card card = new Card(CardNumberEnum.ACE, CardTypeEnum.HEART);
        assertEquals("1하트",card.toString());
    }
    @Test
    void setCard_K_spade(){
        Card card = new Card(CardNumberEnum.KING, CardTypeEnum.SPADE);
        assertEquals("K스페이드",card.toString());
    }
    @Test
    void isBust(){
        Cards cards = new Cards();
        cards.add(new Card(CardNumberEnum.EIGHT, CardTypeEnum.ClOVER));
        cards.add(new Card(CardNumberEnum.EIGHT, CardTypeEnum.SPADE));
        cards.add(new Card(CardNumberEnum.EIGHT, CardTypeEnum.HEART));
        assertTrue(cards.isBust());
    }

    @Test
    void isBlackjackTrue(){
        Cards cards = new Cards();
        cards.add(new Card(CardNumberEnum.EIGHT, CardTypeEnum.ClOVER));
        cards.add(new Card(CardNumberEnum.EIGHT, CardTypeEnum.SPADE));
        cards.add(new Card(CardNumberEnum.EIGHT, CardTypeEnum.HEART));
        assertFalse(cards.isBlackjack());
    }

    @Test
    void isBlackjackFalse(){
        Cards cards = new Cards();
        cards.add(new Card(CardNumberEnum.JACK, CardTypeEnum.ClOVER));
        cards.add(new Card(CardNumberEnum.ACE, CardTypeEnum.HEART));
        assertTrue(cards.isBlackjack());
    }

    @Test
    void isFinished(){
        Cards cards = new Cards();
        cards.add(new Card(CardNumberEnum.JACK, CardTypeEnum.ClOVER));
        cards.add(new Card(CardNumberEnum.ACE, CardTypeEnum.HEART));
        State state = new Hit(cards);
        state  = state.stay();
        assertTrue(state.isFinished());
    }

}
