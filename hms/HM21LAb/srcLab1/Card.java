public class Card {
    private String suit;
    private String value;
    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;

    }
    public void cards(){
        System.out.printf("%s-%s", value,suit);
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }
}
