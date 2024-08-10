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


    @Override
    public String toString(){
        return value = "-" + suit.charAt(0);
    }

        public String getSuit() {
            return suit;
        }

        public String getValue() {
            return value;
        }
    }

