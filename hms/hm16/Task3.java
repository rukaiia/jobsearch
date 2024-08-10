import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3 {

    public static void main(String[] args) {
       
        Event startOfDay = new Event("Начало дня");
        Event wakeUpLeft = new Event("Поднимаюсь с кровати с левой ноги");
        Event wakeUpRight = new Event("Поднимаюсь с кровати с правой ноги");
        Event fallOutOfBed = new Event("Падаю с кровати");
        Event jogInAlley = new Event("Пробежка по аллее");
        Event balconyWorkout = new Event("Физ.зарядка на балконе");
        Event makeStrongCoffee = new Event("Варю крепкий кофе");
        Event prepareBreakfast = new Event("Готовлю плотный завтрак");
        Event getYesterdaySalad = new Event("Достаю вчерашний салат");
        Event flatTire = new Event("Спустило колесо");
        Event walkToWork = new Event("Добираюсь на работу пешком");
        Event takeBusToWork = new Event("Добираюсь на работу на маршрутке");
        Event driveToWork = new Event("Добираюсь на работу на своем авто");
        Event arriveOnTime = new Event("Прихожу вовремя");
        Event lateForWork = new Event("Опаздываю на работу");
        Event endOfDay = new Event("Конец");

        
        startOfDay.setOptions(wakeUpLeft, wakeUpRight);
        wakeUpLeft.setOptions(fallOutOfBed, jogInAlley);
        wakeUpRight.setOptions(fallOutOfBed, balconyWorkout);
        fallOutOfBed.setOptions(makeStrongCoffee, flatTire);
        jogInAlley.setOptions(prepareBreakfast, getYesterdaySalad);
        balconyWorkout.setOptions(makeStrongCoffee, getYesterdaySalad);
        makeStrongCoffee.setOptions(walkToWork, driveToWork);
        prepareBreakfast.setOptions(walkToWork, driveToWork);
        getYesterdaySalad.setOptions(walkToWork, driveToWork);
        flatTire.setOptions(driveToWork, takeBusToWork);
        walkToWork.setOptions(arriveOnTime, lateForWork);
        takeBusToWork.setOptions(arriveOnTime, lateForWork);
        driveToWork.setOptions(arriveOnTime, lateForWork);

       
        Event currentEvent = startOfDay;

     
        List<String> actions = new ArrayList<>();

      
        Random random = new Random();

        
        while (currentEvent != null && !currentEvent.getName().equals("Конец")) {
         
            actions.add(currentEvent.getName());

          
            if (currentEvent.getName().equals("Падаю с кровати"))
                break;

            if (currentEvent != null) {
                currentEvent = currentEvent.chooseNextEvent(random.nextDouble());
            } else {
                break;
            }
        }

        System.out.println("# | Действие");
        System.out.println("---|------------------------------------");
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%2d | %s%n", i + 1, actions.get(i));
        }
    }
}

class Event {
    private String name;
    private Event option1;
    private Event option2;

    public Event(String name) {
        this.name = name;
    }

    public void setOptions(Event option1, Event option2) {
        this.option1 = option1;
        this.option2 = option2;
    }

    public Event chooseNextEvent(double randomNumber) {

        if (randomNumber <= 0.5) {
            return option1;
        } else {
            return option2;
        }
    }

    public String getName() {
        return name;
    }
}
