package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private static final int BLACK_JACK = 21;
    public String name;
    public List<Card> cardList;
    public int betMoney;
    public int benefit;

    public Person(String name, List<Card> cardList) {
        this.name = name;
        this.cardList = cardList;
    }
    public Person(String name) {
        this.name = name;
        this.cardList = new ArrayList<>();
    }
    public void addCard(Card card){
        this.cardList.add(card);
    }
    public void addBetMoney(int money){
        this.betMoney += money;
    }
    public int addBenefit(){
        this.benefit += betMoney;
        return betMoney;
    }
    public void lossBenefit(int money){
        this.benefit -= money;
    }
    public int getScore(){
        return cardList.stream().mapToInt(Card::getScore).sum();
    }
    public String getReport() {
        return this + " - 결과: " + getScore();
    }

    public boolean isBlackJack() {
        return getScore() == BLACK_JACK;
    }

    public boolean isOver(){
        return getScore() > BLACK_JACK;
    }

    public String getBenefitReport() {
        return this.name+": "+this.benefit;
    }

    public void getCard(){
        this.cardList.add(new Card());
    }
    @Override
    public String toString(){
        return this.name+"카드: "+cardList.stream().map(Card::toString).collect(Collectors.joining(","));
    }

    public String getName() {
        return this.name;
    }

    public void returnBetMoney() {
        this.betMoney = 0;
    }

    public void addBenefitForFirstBlackJack() {
        this.benefit += betMoney*1.5;
        this.betMoney = 0;
    }

    public int getDifference(){
        return Math.abs(BLACK_JACK - getScore());
    }

    public void lossAllBenefit() {
        this.benefit -= betMoney;
    }

    public int getBetMoney() {
        return this.betMoney;
    }
}
