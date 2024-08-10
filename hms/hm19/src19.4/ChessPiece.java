abstract class ChessPiece {
    protected  String place;
    protected String color;
    protected String name;

    public ChessPiece(String place, String color, String name){
        this.place = place;
        this.color = color;
        this.name = name;
    }
    @Override
    public  String toString(){


        return String.format("place: %s%n" + "name: %s%n" + "color: %s%n", place,  name, color );
    }


    public String getPlace(){
        return place;
    }
}
