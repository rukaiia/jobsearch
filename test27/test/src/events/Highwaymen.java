package events;

import enums.Quality;
import model.Goods;
import model.Trader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Highwaymen extends Events{
    Trader trader = new Trader();
    Goods goods = new Goods();
    public Highwaymen() {
        super("Встретили разбойников",3);
    }

    @Override
    public void AppRunner(Trader trader, List<Goods> goodsList) {
        System.out.println("Разбойники большой дороги.");
        payHighwaymen(goodsList);
    }

    private void payHighwaymen(List<Goods> goodsList) {
        if (trader.getMoney() > 0) {
            trader.setMoney(0);
            System.out.println("Разбойники забрали все деньги.");
        } else if (!goodsList.isEmpty()) {
           // метод для нахождения лучшего товара
            List<Goods> bestGoods = getBestGoods(goodsList);
            if (!bestGoods.isEmpty()) {
                goodsList.remove(bestGoods);
                System.out.println("Разбойники забрали лучший товар ");
            }
        } else {
            System.out.println("У торговца нет денег и товаров для откупа.");
        }
        //сортировка по качеству товара, не затрагивая осн коллекцию
    }

    private List<Goods> getBestGoods(List<Goods> goodslist){
        List<Goods> bestGoods = new ArrayList<>();
        for(Goods goods : goodslist){
            if(goods.getQuality() == Quality.NORMAL || goods.getQuality() == Quality.SLIGHTLY_SPOILED){
                bestGoods.add(goods);
            }
        }
        return bestGoods;
    }
}
