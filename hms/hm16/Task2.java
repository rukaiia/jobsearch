import java.util.Random;

public class Task2 {

    public static void main(String[] args) {
      
        String transportMethod = chooseTransportMethod();
        System.out.println("Способ добирания на работу: " + transportMethod);

        
        String[] events = { "Начало дня", "Поднимаюсь с кровати с левой ноги", "Поднимаюсь с кровати с правой ноги",
                "Падаю с кровати", "Пробежка по аллее", "Готовлю плотный завтрак",
                "Достаю вчерашний салат", "Спустило колесо", "Добираюсь на работу пешком",
                "Добираюсь на работу на маршрутке", "Конец" };

      
        String currentEvent = events[0];


        Random random = new Random();


        while (!currentEvent.equals("Конец")) {
            System.out.println(currentEvent);

            if (currentEvent.equals("Падаю с кровати"))
                break;

            double randomNumber = random.nextDouble();

            if (currentEvent.equals("Начало дня")) {
                currentEvent = randomNumber <= 0.2 ? events[1] : events[2];
            } else if (currentEvent.equals("Поднимаюсь с кровати с левой ноги") ||
                    currentEvent.equals("Поднимаюсь с кровати с правой ноги")) {
                currentEvent = randomNumber <= 0.3 ? events[3] : events[4];
            } else if (currentEvent.equals("Пробежка по аллее")) {
                currentEvent = randomNumber <= 0.6 ? events[7] : events[8];
            } else if (currentEvent.equals("Добираюсь на работу пешком") ||
                    currentEvent.equals("Добираюсь на работу на маршрутке")) {
                currentEvent = events[10]; 
            } else {
                currentEvent = events[10]; 
            }
        }
    }

   
    public static String chooseTransportMethod() {
        Random random = new Random();
        double randomNumber = random.nextDouble();

       
        if (randomNumber < 0.5) {
            return "Добираюсь на работу пешком";
        } else {
            return "Добираюсь на работу на маршрутке";
        }
    }
}
