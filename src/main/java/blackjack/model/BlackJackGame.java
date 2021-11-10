package blackjack.model;

import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackGame {

    Players players;
    Dealer dealer;

    public BlackJackGame(Players players) {
        this.players = players;
        this.dealer = new Dealer();
    }

    public void betting(){
        players.getPlayers().forEach(InputView::getBetAmount);
    }

    public void setUpGame(){
        players.getStart();
        dealer.getStart();
    }

    public void playing(){
        //딜러가 블랙잭이면 게임 종료
        if(dealer.isBlackJack()){
            players.stay();
            return;
        }
        //카드뽑기
        players.getPlayers().forEach(this::personalHit);

        // 딜러 추가 뽑기
        while(dealer.isLow()){
            dealer.hit();
            OutputView.getDealerHitMessage();
        }
    }
    public String getPlayersName() {
        return players.getNames();
    }

    public String getCardList() {
        return players.toString()+"\n"+dealer.toString();
    }

    public void personalHit(Player player){
        while(player.isFinished() && InputView.isHit(player)){
            player.hit();
            OutputView.printMessageForHit(player);
        }
        if(player.isFinished()){
            player.stay();
        }
    }
}
