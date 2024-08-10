public class Bicycle extends Transport{
    public Bicycle(String brand, String model, int speed) {
        super(brand, model, speed);
    }


    @Override
    boolean isMoving() {

        return false;
    }
}
