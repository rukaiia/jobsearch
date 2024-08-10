
abstract class Transport {

    String brand;
    String model;
    int speed;


    public Transport(String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }


    abstract boolean isMoving();
}








