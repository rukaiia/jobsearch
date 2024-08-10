package events;

import model.Goods;
import model.Trader;

import java.util.List;
import java.util.Random;

public class MetALocal extends Events{
    public MetALocal() {
        super("Встретил местного.",3);
    }

    @Override
    public void AppRunner(Trader trader, List<Goods> goodsList) {
        System.out.println("Удалось срезать часть пути");
        trader.setSpeed(trader.getSpeed() + new Random().nextInt(4) + 3);
    }
}
