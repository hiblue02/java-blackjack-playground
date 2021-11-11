package blackjack;

import blackjack.controller.BlackJackGame;
import blackjack.model.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackGameMain {


    public static void main(String[] args) {
        BlackJackGame blackJackGame = new BlackJackGame(InputView.getPlayers());
        blackJackGame.betting();
        blackJackGame.setUpGame();
        OutputView.printMessageForSetup(blackJackGame);
        blackJackGame.playing();
        OutputView.printReport(blackJackGame);
        OutputView.printProfitReport(blackJackGame);
    }


}
