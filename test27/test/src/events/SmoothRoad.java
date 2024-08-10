package events;

import model.Goods;
import model.Trader;

import java.util.List;

public class SmoothRoad extends Events{

    public SmoothRoad() {
        super("Ровная дорога.",3);
    }

    @Override
    public void AppRunner(Trader trader, List<Goods> goodsList) {
        if(trader.getSpeed() == 5){
            trader.setSpeed(trader.getSpeed());
            System.out.println("Скорость не может быть повышена, она максимальна");
        } else if (trader.getSpeed() == 4) {
            trader.setSpeed(trader.getSpeed() + 1);
            System.out.println("Скорость повышена до максимальной");
        } else {
            trader.setSpeed(trader.getSpeed() + 2);
            System.out.println("Скорость повышена на 2 лиги в день ");
        }
    }
}
