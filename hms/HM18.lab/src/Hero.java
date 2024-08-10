import java.util.Random;
import java.util.Scanner;

public class Hero {
    private int HP ;
    private int strength ;
    private int defence ;
    private int weapon ;
    private int shield ;


    Scanner scanner = new Scanner(System.in);
    Random random = new Random();


    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public Hero(int HP, int defence, int strength, int weapon, int shield) {
        this.HP = HP;
        this.defence = defence;
        this.weapon = weapon;
        this.strength =strength;
        this.shield = shield;

    }
    public void attack(Dragon dragon){
        if(Math.random() <= 0.75){
            int hr = this.strength + this.weapon - dragon.getDefence();
             int dragonh = dragon.getHP() - hr;
                dragon.setHP(dragonh);
            System.out.println("Вы попали по дракону! Нанесено урона:" + hr);
            System.out.println("У Антагониста осталось жизни: " + dragonh);

        }
        else {
            System.out.println("Вы не попали :(");
        }

    }
public boolean Dragonhealth(Dragon dragon){
        if(dragon.getHP() <= 0){
            System.out.println("Антагонист проиграл :)");
            return true;
        }
    return false;

}
    public void shield(Dragon dragon) {
        int hp = this.defence + this.shield;
        int damage =  Math.max(0,dragon.getStrength() + dragon.getWeapon() - hp);

        int HP2 = this.HP - damage;
        this.HP = HP;
        System.out.println("Антагонист попал на героя! Нанесено урона: " + damage);
        System.out.println(" Герой защитился! У героя осталось жизни: " + HP2);
    }
    public boolean isAlive() {
        return HP > 0;

    }
}


