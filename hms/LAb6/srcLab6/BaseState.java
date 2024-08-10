class BaseState implements TruckState {
    private Truck truck;

    public BaseState(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void changeDriver(Driver newDriver) {
        System.out.println("Теперь грузовик " + truck.getName() + " ведёт водитель " + newDriver.getName());
        truck.setDriver(newDriver);
    }

    @Override
    public void startDriving() {
        if (truck.getDriver() != null) {
            System.out.println("Грузовик " + truck.getName() + " отправлен на маршрут.");
            truck.setState(new RouteState(truck));
        } else {
            System.out.println("Грузовик " + truck.getName() + " не может выйти на маршрут без водителя.");
        }
    }

    @Override
    public void startRepair() {
        System.out.println("Грузовик " + truck.getName() + " отправлен на ремонт.");
        truck.setState(new RepairState(truck));
    }
}

