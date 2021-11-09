package blackjack.model;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackJackGame {

    Players players;
    Dealer dealer;

    public BlackJackGame(Players players) {
        this.players = players;
        this.dealer = new Dealer();
    }

    public void setUpGame(){
        players.getStart();
        dealer.getStart();

        if(dealer.isLow()){
            dealer.draw();
        }

    }
}
