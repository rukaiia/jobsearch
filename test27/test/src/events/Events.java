package events;

import model.Goods;
import model.Trader;

import java.util.List;

public abstract class Events {
    private String eventsName;
    private int cartSpeed;

    public Events(String eventsName, int cartSpeed) {
        this.eventsName = eventsName;
        this.cartSpeed = cartSpeed;
    }

    public abstract void AppRunner(Trader trader, List<Goods> goodsList);

    public void speedChangingByEvent(Trader trader, Goods goods) {
        trader.setSpeed(trader.getSpeed() + cartSpeed);
        goods.damageGoods();
    }

    public String getEventsName() {
        return eventsName;
    }
    public int getCartSpeed() {
        return cartSpeed;
    }
}
