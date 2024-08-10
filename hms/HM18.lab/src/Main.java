import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static <Creature> void main(String[] args) {
        Dragon dragon = new Dragon(2000, 200, 150, 0);
        Hero hero = new Hero(1000, 100, 120, 250, 50);
        Dragon hellG = new Dragon(1000, 190, 100, 0);


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

         Dragon antagonist;



        if (random.nextBoolean()) {
             antagonist = dragon;
            System.out.println("Антагонист: Дракон");
        } else {
            antagonist = hellG;
            System.out.println("Антагонист: Адская гончая");
        }

        System.out.println("===========Начать бой================");

        while (true) {
            System.out.println("-----------Ход Героя------------");
            System.out.println("Выберите действие: ");
            System.out.println("1. Атаковать");
            System.out.println("2. Не атаковать");
            System.out.println("3. Защищаться");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    hero.attack(antagonist);
                    break;
                case 2:
                    antagonist.attackHero(hero);
                    break;
                case 3:
                    hero.shield(antagonist);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    continue;
            }

            if (hero.Dragonhealth(antagonist)) {
                break;
            }

            System.out.println("-----------Ход Антагониста------------");
            antagonist.attackHero(hero);
            System.out.println("===== Следующий раунд ======");
        }

        if (hero.getHP() <= 0) {
            System.out.println("Игра окончена! Герой проиграл :(");
        } else {
            System.out.println("Игра окончена! Герой победил :)");
        }
    }
}
