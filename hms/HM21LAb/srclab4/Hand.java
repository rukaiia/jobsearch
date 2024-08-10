import java.util.ArrayList;
import java.util.List;

public class Hand {

        private List<Card> cards;
        public Hand() {
            this.cards = new ArrayList<>();
        }


        public void addCard(Card card) {
            cards.add(card);
        }

        public void replaceCard(int position, Card newCard) {
            if (position >= 0 && position < cards.size()) {
                cards.set(position, newCard);
            } else {
                System.out.println("Позиция не существует!");
            }
        }

        public void displayHand() {
            System.out.print("  ");
            for (int i = 0; i < cards.size(); i++) {
                System.out.printf("%4d", i + 1);
            }
            System.out.println();

            System.out.print("  ");
            for (int i = 0; i < cards.size(); i++) {
                System.out.printf("%4s", "|");
            }
            System.out.println();

            System.out.print("  ");
            for (Card card : cards) {
                System.out.printf("%4s", card);
            }
            System.out.println();
        }
    }

