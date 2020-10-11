package poker;

import java.util.*;

public class Game {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        initializeCards(cards);
        List<Player> players = new ArrayList<>();
        players.add(new Player("周润发"));
        players.add(new Player("刘德华"));
        players.add(new Player("周星驰"));
        players.add(new Player("王老五"));
        players.add(new Player("梅老六"));
        Collections.shuffle(cards);
        dealCards(players,cards);
        for (Player player : players){
            System.out.printf("[%s] 的手牌 %s%n",player.name,player.cardList);
        }
        judgeWin(players);
        drawCard(players);
        for (Player player : players){
            System.out.printf("[%s] 的手牌 %s%n",player.name,player.cardList);
        }
        judgeWin(players);
        conjure(players,players.get(0));
        for (Player player : players){
            System.out.printf("[%s] 的手牌 %s%n",player.name,player.cardList);
        }
        judgeWin(players);
    }

    private static void conjure(List<Player> players,Player playerF) {
        Card cardA = new Card("♠",1);
        for(Player player : players){
            for (int rank = 0; rank <= 3; rank++){
                if(player.cardList.get(rank).equals(cardA)){
                    player.cardList.remove(player.cardList.get(rank));
                    player.cardList.add(rank,playerF.cardList.get(0));
                    playerF.cardList.remove(0);
                    playerF.cardList.add(0,cardA);
                }
            }
        }
    }

    private static void drawCard(List<Player> players) {
        Card card  = null;
        Random random = new Random();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int num =random.nextInt(player.cardList.size());
            card = player.cardList.remove(num);
            if (i < players.size() - 1) {
                players.get(i + 1).cardList.add(card);
            }
        }
        players.get(0).cardList.add(card);
    }

    private static void judgeWin(List<Player> players) {
        Card card = new Card("♠",1);
        for(Player player : players){
            for (Card card1 : player.cardList){
                if(card1.equals(card)){
                    System.out.println("胜者为"+player.name);
                    return ;
                }
            }
        }
        System.out.println("本局无胜者");
    }

    private static void dealCards(List<Player> players,List<Card> cards){
        int n = 4;
        for (int i = 0; i < n; i++) {
            for (Player player : players){
                Card card = cards.remove(0);
                player.cardList.add(card);
            }
        }
    }
    private static void initializeCards(List<Card> cards) {
        for (String suit : new String[]{"♠", "♣", "♦", "♥"}) {
            for (int rank = 1; rank <= 5; rank++) {
                Card card = new Card(suit,rank);
                cards.add(card);
            }
        }
    }

}
