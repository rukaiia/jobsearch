public class Queen {
     String place;
    String name;
    String color;

    public Queen(String place, String name, String color){
        this.color = color;
        this.name = name;
        this.place = place;

    }
     @Override
    public  String toString(){


        return String.format("place: %s%n" + "name: %s%n" + "color: %s%n", place,  name, color );
    }
    public void pls(String newplace){
        newplace = place;



    }
    public String getPlace(){
        return place;
    }
}
