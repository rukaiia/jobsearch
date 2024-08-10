import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Tiles", "Cloves", "Pikes"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card takeCard() {
        if (!cards.isEmpty()) {
            Card drawnCard = cards.remove(0);
            return drawnCard;
        } else {
            System.out.println("Колода пуста!");
            return null;
        }
    }

    public void returnCard(Card card) {
        if (!cards.contains(card)) {
            cards.add(card);
            shuffle();
        } else {
            System.out.println("Карта уже находится в колоде!");
        }
    }
}

