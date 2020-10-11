package poker;

import java.util.Objects;

public class Card {
    private String suit;
    private int rand;

    @Override
    public String toString() {
        return "[" +
                suit + ' ' + rand +
                ']';
    }

    public Card(String suit, int rand) {
        this.suit = suit;
        this.rand = rand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rand == card.rand &&
                Objects.equals(suit, card.suit);
    }
}
