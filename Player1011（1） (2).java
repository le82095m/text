package playingCARD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();
        initializeCards(cardList);
        List<Player> players = new ArrayList<>();
        players.add(new Player("周润发"));
        players.add(new Player("刘德华"));
        players.add(new Player("周星驰"));
        players.add(new Player("张家辉"));
        players.add(new Player("梁朝伟"));
        Collections.shuffle(cardList);
        printCards(players);
        game(players,cardList);
        printCards(players);
    }

    private static void game(List<Player> players, List<Card> cardList) {
        while (true){
            if(cardList == null){
                return;
            }
            for (Player player : players) {
                Card card1 = cardList.remove(0);
                for (Card card : player.cards) {
                    if (card.equals(card1)){
                        player.cards.remove(card);
                    }
                }
                player.cards.add(card1);
            }
        }
    }

    private static void printCards(List<Player> players) {
        for(Player player : players){
            System.out.printf("[%s] 的手牌是: %s%n",player.name,player.cards);
        }
    }

    private static void dealCards(List<Player> players, List<Card> cardList) {
        int n = 4;
        for (Player player : players){
            for (int rank = 0; rank < n ; rank++) {
                Card card = cardList.remove(0);
                player.cards.add(card);
            }
        }
    }

    private static void initializeCards(List<Card> cardList) {
        for(String suit : new String[]{"♠","♣","♦","♥"}){
            for (int rank = 1; rank <=5 ; rank++) {
                Card card = new Card(suit,rank);
                cardList.add(card);
            }
        }
    }
}
