package blackjack.model;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlackJackGame {

    private static final int START_GAME_CARD_COUNT = 2;

    /**
     * 게임시작
     * 참가자에게 카드 2장씩 나눠주기
     */
    public void play(List<Person> participants){
        //① 딜러 선언
        Dealer dealer = new Dealer();
        dealer.addBenefit(participants.stream().mapToInt(Person::getBetMoney).sum());
        //② 카드 2장씩 나누기
        for(int i = 0; i<START_GAME_CARD_COUNT; i++){
            dealer.getCard();
            participants.forEach(Person::getCard);
        }
        //③ 결과 메세지 출력
        printAlertMessage(participants,dealer);
        //④최초 블랙잭 확인;
        if(participants.stream().anyMatch(Person::isBlackJack)){
            distributionForFirstBlackJack(participants, dealer);
            return;
        }

        //⑤ 게임 진행
        participants.forEach(this::getCard);
        //⑥ 딜러 확인
        while(dealer.isUnder()){
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            dealer.getCard();
        }

        //⑦ 승자 확인
        if(dealer.isOver()){
            participants.forEach(a-> dealer.lossBenefit(a.addBenefit()));
            return;
        }

        participants.add(dealer);
        int min = participants.stream().mapToInt(Person::getDifference).min().getAsInt();

        for (Person participant : participants) {
            if(participant.isOver()){
                participant.lossAllBenefit();
            }
            if(participant.getDifference() == min){
                dealer.lossBenefit(participant.addBenefit());
            }
        }

    }

    private void distributionForFirstBlackJack(List<Person> participants, Dealer dealer) {

        if(dealer.isBlackJack()){
           participants.stream().filter(Person::isBlackJack).forEach(Person::returnBetMoney);
           return;
        }
        participants.stream().filter(Person::isBlackJack).forEach(Person::addBenefitForFirstBlackJack);
    }

    public boolean isNotValidAnswer(String answer) {
        Pattern pattern = Pattern.compile("[yYnN]");
        Matcher matcher = pattern.matcher(answer);
        return matcher.matches();
    }

    private void printAlertMessage(List<Person> participants, Dealer dealer) {
        String alertMessage = "딜러와 "+participants.stream().map(Person::getName).collect(Collectors.joining(","))
                +"에게"
                +START_GAME_CARD_COUNT+"장의 카드을 나누었습니다.\n";
        System.out.println(alertMessage);
        System.out.println(dealer.toString());
        participants.forEach(System.out::println);
    }
    private void getCard(Person participant){
        String answer;
        while(true){
            System.out.println(participant.getName()+"는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
            //값 정확성 확인 : 잘못된 값이면 다시 질문
            if (isNotValidAnswer(answer)) {
                System.out.println("잘못된 값입니다.");
                continue;
            }
            // 값이 n이면 루프 정지
            if (answer.equalsIgnoreCase("n")) {
                break;
            }
            participant.getCard();
        }
    }

}
