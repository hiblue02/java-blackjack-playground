package blackjack.view;

import blackjack.model.BlackJack;
import blackjack.model.BlackJackGame;
import blackjack.model.Player;

public class OutputView {

    public static void printMessageForSetup(BlackJackGame blackJackGame){

        String message = "딜러와 " +
                blackJackGame.getPlayersName() +
                " 2장의 카드를 나누었습니다";
        System.out.println(message);
        System.out.println(blackJackGame.getCardList());
    }

    public static void getDealerHitMessage(){
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printMessageForHit(Player player){
        System.out.println(player.toString());
    }

    public static void printReport(BlackJackGame blackJackGame){
        System.out.println(blackJackGame.getReport());
    }

    public static void printProfitReport(BlackJackGame blackJackGame){
        System.out.println(blackJackGame.getProfitReport());
    }



}
