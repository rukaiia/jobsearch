public class Main {
    public static void main(String[] args) {
                Card card1 = new Card("Hearts", "A");
                Card card2 = new Card("Cloves", "2");
                Card card3 = new Card("Tiles", "10");
                Card card4 = new Card("Pikes", "Q");
                Card card5 = new Card("Tiles", "K");

                Hand hand = new Hand();

                hand.addCard(card1);
                hand.addCard(card2);
                hand.addCard(card3);
                hand.addCard(card4);
                hand.addCard(card5);

                System.out.println("Рука игрока:");
                hand.displayHand();
                System.out.println();

                Card newCard = new Card("Pikes", "8");
                hand.replaceCard(2, newCard);

                System.out.println("Рука игрока после замены карты на позиции 3:");
                hand.displayHand();
            }
        }
