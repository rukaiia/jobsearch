package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trader {
    private List<Goods> goods = new ArrayList<>();
    private int loadCapacity ;
    private int speed  = new Random().nextInt(5) + 1;
    private  int money  = new Random().nextInt(130) + 470;
    private int destinationCity;

    public Trader(int speed, int money) {
        this.speed = speed;
        this.money = money;
    }

    public Trader() {}
    public Trader(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getLoadCapacity() {
        return loadCapacity;
    }
    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    public int getSpeed() {
        return speed;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
}
