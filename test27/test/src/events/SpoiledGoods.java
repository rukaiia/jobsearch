package events;

import enums.Quality;
import model.Goods;
import model.Trader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpoiledGoods extends Events{
    Goods goods = new Goods();
    public SpoiledGoods() {
        super("Один из товаров испортился",3);
    }

    @Override
    public void AppRunner(Trader trader, List<Goods> goodsList) {
        if (!goodsList.isEmpty()) {
            int index = new Random().nextInt(goodsList.size());
            goodsList.get(index).damageGoods();
            System.out.printf("Товар %s испорчен, его новое состояние: %s", goodsList.get(index).getTypeOfGoods(), goodsList.get(index).getQuality());

//            Goods spoiledGoods = goods.get();//берем испорченные товары
//            Quality currentQuality = spoiledGoods.getQuality();
//            Quality newQuality = currentQuality.spoilageOfGoods();
//            spoiledGoods.setQuality(newQuality);
//            System.out.println("Товар " + spoiledGoods.getTypeOfGoods() +
//                    " испортился. Новое качество: " + newQuality);
        } else {
            System.out.println("Не осталось товаров.");
        }
    }

}
