package enums;
public enum Quality {
    NORMAL("Нормальное",1.2){
        @Override
        public Quality spoilageOfGoods() {
            return SLIGHTLY_SPOILED;
        }
    },
    SLIGHTLY_SPOILED("Слегка испорчен",0.95) {
        @Override
        public Quality spoilageOfGoods() {
            return HALF_BAD;
        }
    },
    HALF_BAD("Наполовину испорчен",0.55) {
        @Override
        public Quality spoilageOfGoods() {
            return ALMOST_ALL_GONE;
        }
    },
    ALMOST_ALL_GONE("Почти весь пропал",0.25) {
        @Override
        public Quality spoilageOfGoods() {
            return TRASH;
        }
    },
    TRASH("Испорчен в хлам",0.1) {
        @Override
        public Quality spoilageOfGoods() {
            return TRASH;
        }
    };
    private String name;
    private double value;
    Quality(String name, double value) {
        this.value = value;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public double getValue() {
        return value;
    }
    public abstract Quality spoilageOfGoods();
}
