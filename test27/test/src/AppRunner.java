import model.Application;
import model.City;
import model.Goods;
import model.Trader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppRunner {
    private Trader trader = new Trader(45);
    private City city = new City();
    private List<City> cities = new ArrayList<>();
    private Application application = new Application();
    private List<Goods> goods = application.fillGoods();
    public void run() {
        application.fillCities(cities);
        System.out.println(application.getRandomCity(cities));
        System.out.println("Начальное количество денег: " + trader.getMoney());
        System.out.println("Начальный вес: " + trader.getLoadCapacity());

        List<Goods> getRandomGoods = fillCart(goods);
        System.out.println(getRandomGoods);


        System.out.println("Оставшееся количество денег: " + trader.getMoney());
        System.out.println("Конечный вес: " + trader.getLoadCapacity());
    }
    public Goods getRandomGoods(List<Goods> goods){
        Random rand = new Random();
        return goods.get(rand.nextInt(goods.size()));
    }
    public List<Goods> fillCart(List<Goods> goods) {
        List<Goods> randomGoods = new ArrayList<>();
        for (int i = 0; i < trader.getMoney() ; i++) {
            Goods good = getRandomGoods(goods);
            randomGoods.add(good);
            if(good.getBuyPrice() > trader.getMoney() || trader.getLoadCapacity() < Math.max(good.getWeight(), 0)) {
                break;
            }
            trader.setMoney(trader.getMoney() - good.getBuyPrice());
            trader.setLoadCapacity(trader.getLoadCapacity() - good.getWeight());
        }
        return randomGoods;
    }
}
