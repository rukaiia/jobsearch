class Truck {
    private int id;
    private String name;
    private Driver driver;
    private TruckState state;

    public Truck(int id, String name) {
        this.id = id;
        this.name = name;
        this.state = new BaseState(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public TruckState getState() {
        return state;
    }

    public void setState(TruckState state) {
        this.state = state;
    }

    public void changeDriver(Driver newDriver) {
        state.changeDriver(newDriver);
    }

    public void startDriving() {
        state.startDriving();
    }

    public void startRepair() {
        state.startRepair();
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", driver=" + driver +
                ", state=" + state +
                '}';
    }
}
