package blackjack.view;

import blackjack.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    /** 참가자 이름 받기**/
    public List<Player> getPlayers(){

        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        String input = scanner.nextLine();
        String[] playerNames = input.split(",");
        List<Player> players = new ArrayList<>();

        Arrays.stream(playerNames).forEach(a->players.add( new Player(a.trim())));

        return players;
    }

    /** 배팅금액 입력받기 **/
    public void getBetAmount(Player player){
        System.out.println(player.getName()+"의 배팅금액은?");
        player.setBetAmount( Integer.parseInt(scanner.nextLine()));
    }

}
