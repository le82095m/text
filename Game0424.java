package playingCARD;

import java.util.*;

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
        game(players,cardList);
        printCards(players);
        System.out.println();
        while (players.size() > 1) {
            judgeGhost(players);
            printCards(players);
            System.out.println();
        }
    }

    private static void judgeGhost(List<Player> players) {
        boolean ifAdd = true;
        int num = 0;
        Card card = null;
        Random random = new Random();
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            num = random.nextInt(players.get(i-1).cards.size());
            card = players.get(i-1).cards.remove(num);
            if (i < players.size() - 1) {
                for (Card value : players.get(i).cards) {
                    if (value.rank == card.rank) {
                        players.get(i).cards.remove(card);
                        ifAdd = false;
                    }
                }
                if (ifAdd) {
                    players.get(i).cards.add(card);
                }
            }
            players.removeIf(player1 -> player.cards.isEmpty());
        }
        ifAdd = true;
        for (Card value : players.get(0).cards) {
            if(card == null){
                return;
            }
            if (value.rank == card.rank) {
                players.get(0).cards.remove(card);
                ifAdd = false;
            }
        }
        if (ifAdd) {
            players.get(0).cards.add(card);
        }
        players.removeIf(player -> player.cards.isEmpty());
    }

    private static void game(List<Player> players, List<Card> cardList) {
        while (!cardList.isEmpty()) {
            boolean ifAdd = true;
            for (Player player : players) {
                Card card = cardList.remove(0);
                for (Card value : player.cards) {
                    if (value.rank == card.rank) {
                        player.cards.remove(card);
                        ifAdd = false;
                    }
                }
                if (ifAdd) {
                    player.cards.add(card);
                }
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
