public class Main {
    public static void main(String[] args) {
        Car car = new Car("Lexus", "RX", 200);
        Bicycle bicycle = new Bicycle("BMW", "M5", 60);
        Airplane airplane = new Airplane("rdgdfg", "6765", 800);


        System.out.println("Машина едет: " + car.isMoving());
        System.out.println("Велосипед едет: " + bicycle.isMoving());
        System.out.println("Самолет едет: " + airplane.isMoving());
    }
}