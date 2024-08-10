package model;
import enums.Quality;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Application {
    public List<Goods> fillGoods() {
        List<Goods> goods = new ArrayList<>();
        List <Goods> copyGoods = new ArrayList<>(goods);
        copyGoods.add(new Goods(8, "Мясо", 80, 100, Quality.NORMAL.getName()));
        copyGoods.add(new Goods(6, "Сухофрукты", 60, 80, Quality.NORMAL.getName()));
        copyGoods.add(new Goods(5, "Зерно", 50, 60, Quality.NORMAL.getName()));
        copyGoods.add(new Goods(5, "Мука", 50, 60, Quality.NORMAL.getName()));
        copyGoods.add(new Goods(3, "Ткани", 90, 120, Quality.NORMAL.getName()));
        copyGoods.add(new Goods(2, "Краска", 40, 50, Quality.NORMAL.getName()));
        return copyGoods;
    }
    public void fillCities(List<City> cities) {
        cities.add(new City("Tokyo"));
        cities.add(new City("Hiroshima"));
        cities.add(new City("Osaka"));
        cities.add(new City("Kyoto"));
        cities.add(new City("Nagoya"));
        cities.add(new City("Kawasaki"));
        cities.add(new City("Sendai"));
    }

    public City getRandomCity(List<City> cities) {
        Random rand = new Random();
        return cities.get(rand.nextInt(cities.size()));
    }

}
