package blackjack.view;

import blackjack.model.Player;
import blackjack.model.Players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String ERROR_MESSAGE = "잘못입력하셨습니다. 다시 입력해주세요.";
    private static Scanner scanner = new Scanner(System.in);

    /** 참가자 이름 받기**/
    public static Players getPlayers(){

        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        String input = scanner.nextLine();
        String[] playerNames = input.split(",");

        List<Player> players = new ArrayList<>();

        Arrays.stream(playerNames).forEach(a->players.add( new Player(a.trim())));

        return new Players(players);
    }

    /** 배팅금액 입력받기 **/
    public static int getBetAmount(Player player){
        while(true) {
            System.out.println(player.getName() + "의 배팅금액은?");
            String betMoney = scanner.nextLine();
            try {
                return Integer.parseInt(betMoney);
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public static boolean isHit(Player player){
        while(true){
            System.out.println(player.getName()+"는 한장의 카드를 더 받겠습니까? (예:y, 아니오:n)");
            String answer = scanner.nextLine();
            if("y".equals(answer)){
                return true;
            }
            if("n".equals(answer)){
                return false;
            }
            System.out.println(ERROR_MESSAGE);
        }

    }



}

