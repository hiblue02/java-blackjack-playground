package blackjack;

import blackjack.model.BlackJackGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccuracyTest {

    @Test
    void isNotValidAnswerTrueY(){
        BlackJackGame blackJackGame = new BlackJackGame();
        assertTrue(blackJackGame.isNotValidAnswer("Y"));
    }
    @Test
    void isNotValidAnswerTrueN(){
        BlackJackGame blackJackGame = new BlackJackGame();
        assertTrue(blackJackGame.isNotValidAnswer("N"));
    }
    @Test
    void isNotValidAnswerTruey(){
        BlackJackGame blackJackGame = new BlackJackGame();
        assertTrue(blackJackGame.isNotValidAnswer("y"));
    }
    @Test
    void isNotValidAnswerTruen(){
        BlackJackGame blackJackGame = new BlackJackGame();
        assertTrue(blackJackGame.isNotValidAnswer("n"));
    }
    @Test
    void isNotValidAnswerFalse(){
        BlackJackGame blackJackGame = new BlackJackGame();
        assertFalse(blackJackGame.isNotValidAnswer("AB"));
    }

}
