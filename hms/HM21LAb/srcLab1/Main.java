public class Main {
    public static void main(String[] args) {
  Card card1 = new Card("Cloves", "7");
  Card card2 = new Card("Pikes", "A");
        Card card3 = new Card("Hearts", "K");
        Card card4 = new Card("Tiles", "Q");


        card1.cards();
        System.out.println(",");
        card2.cards();
        System.out.println(",");
        card3.cards();
        System.out.println(",");
        card4.cards();

    }
}