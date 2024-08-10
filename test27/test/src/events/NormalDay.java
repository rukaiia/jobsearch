package events;

import model.Goods;
import model.Trader;

import java.util.List;

public class NormalDay extends Events{

    public NormalDay() {
        super("Обычный день", 3);
    }

    @Override
    public void AppRunner(Trader trader, List<Goods> goodsList) {
        System.out.println("Обычный день, прошел без происшествий!");
    }
}
