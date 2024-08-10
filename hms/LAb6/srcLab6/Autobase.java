import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Autobase {
    private List<Truck> trucks;
    private List<Driver> drivers;
    private Scanner scanner;

    public Autobase() {
        trucks = new ArrayList<>();
        drivers = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadTrucksData("data/trucks.json");
        loadDriversData("data/drivers.json");
    }

    public void start() {
        displayTrucksTable();
        displayDriversTable();
        System.out.println("Введите идентификатор грузовика для просмотра его информации:");
        int truckId = scanner.nextInt();
        Truck selectedTruck = findTruckById(truckId);
        if (selectedTruck != null) {
            System.out.println(selectedTruck);
            System.out.println("Выберите действие:");
            System.out.println("1. Сменить водителя");
            System.out.println("2. Отправить на маршрут");
            System.out.println("3. Отправить на ремонт");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    changeDriver(selectedTruck);
                    break;
                case 2:
                    startDriving(selectedTruck);
                    break;
                case 3:
                    startRepair(selectedTruck);
                    break;
                default:
                    System.out.println("Некорректное действие.");
            }
            displayTrucksTable();
        } else {
            System.out.println("Грузовик с указанным идентификатором не найден.");
        }
    }

    private void loadTrucksData(String filename) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filename));
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                int id = Integer.parseInt(jsonObject.get("id").toString());
                String name = (String) jsonObject.get("name");
                trucks.add(new Truck(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDriversData(String filename) {
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filename));
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String id = (String) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                drivers.add(new Driver(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayTrucksTable() {
        System.out.println("Информация о грузовиках:");
        System.out.println("------------------------------");
        for (Truck truck : trucks) {
            System.out.println(truck);
        }
        System.out.println("------------------------------");
    }

    private void displayDriversTable() {
        System.out.println("Информация о водителях:");
        System.out.println("------------------------------");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.println("------------------------------");
    }

    private void changeDriver(Truck truck) {
        System.out.println("Выберите нового водителя:");
        displayDriversTable();
        String driverId = scanner.next();
        Driver newDriver = findDriverById(driverId);
        if (newDriver != null) {
            truck.setDriver(newDriver);
            System.out.println("Теперь грузовик " + truck.getName() + " ведет водитель " + newDriver.getName());
        } else {
            System.out.println("Водитель с указанным идентификатором не найден.");
        }
    }
    private void startDriving(Truck truck) {
        if (truck.getDriver() != null) {
            System.out.println("Грузовик отправлен на маршрут.");
        } else {
            System.out.println("Невозможно отправить грузовик на маршрут, так как нет водителя.");
        }
    }

    private void startRepair(Truck truck) {
        System.out.println("Грузовик отправлен на ремонт.");
    }

    private Driver findDriverById(String id) {
        for (Driver driver : drivers) {
            if (driver.getId().equals(id)) {
                return driver;
            }
        }
        return null;
    }

    private Truck findTruckById(int id) {
        for (Truck truck : trucks) {
            if (truck.getId() == id) {
                return truck;
            }
        }
        return null;
    }
}


