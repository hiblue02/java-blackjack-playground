package blackjack.controller;

import blackjack.model.BlackJackGame;
import blackjack.model.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackController {


    public static void main(String[] args) {
        Players players = InputView.getPlayers();
        BlackJackGame blackJackGame = new BlackJackGame(players);
        blackJackGame.betting();
        blackJackGame.setUpGame();
        OutputView.printMessageForSetup(blackJackGame);

        blackJackGame.playing();

        OutputView.printReport(blackJackGame);
        OutputView.printProfitReport(blackJackGame);
    }


}
