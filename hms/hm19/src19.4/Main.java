public class Main {
    public static void main(String[] args) {
        Queen queen = new Queen("F1" , "Q", "black");
        King king = new King("D1", "K" , "White");
        Elephant elephant = new Elephant("C1", "B" , "black");
        Rook rook = new Rook("E1" , "R", "White");
        Pawn pawn = new Pawn("F4", "P", "black");

        System.out.println(queen.toString());
        System.out.println("new place:" + queen.getPlace());

        System.out.println(king.toString());
        System.out.println("new place:" + king.getPlace());

        System.out.println(elephant.toString());
        System.out.println("new place:" + elephant.getPlace());

        System.out.println(rook.toString());
        System.out.println("new place:" + rook.getPlace());

        System.out.println(pawn.toString());
        System.out.println("new place:" + pawn.getPlace());
    }
    }
