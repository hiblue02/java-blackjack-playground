package blackjack.controller;

import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.model.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;

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
        if(!dealer.isFinished()){
            dealer.stay();
        }
    }
    public String getPlayersName() {
        return players.getNames();
    }

    public String getCardList() {
        return dealer.toString()+"\n"+
                players.getCardList();
    }

    private void personalHit(Player player){
        while(!player.isFinished() && InputView.isHit(player)){
            player.hit();
            OutputView.printMessageForHit(player);
        }
        if(!player.isFinished()){
            player.stay();
        }
    }

    public void settleGameResult(){
        if(dealer.isBust()){
            players.setWinAll();
        }
        players.settleGameResult();
        double dealerProfit = players.getPlayers().stream().mapToDouble(player->player.profit()*-1).sum();
        dealer.setBetMoney(dealerProfit);
    }

    public String getReport(){
        return  dealer.getReport()+"\n"
                +players.getReport();
    }

    public String getProfitReport(){
        return "## 최종수익\n"
                +dealer.getProfitReport()+"\n"
                +players.getProfitReport();
    }
}
