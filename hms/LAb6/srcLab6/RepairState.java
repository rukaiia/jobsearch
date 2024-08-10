class RepairState implements TruckState {
    private Truck truck;

    public RepairState(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void changeDriver(Driver newDriver) {
        System.out.println("Нельзя сменить водителя у грузовика на ремонте.");
    }

    @Override
    public void startDriving() {
        truck.setState(Math.random() < 0.5 ? new RouteState(truck) : new BaseState(truck));
        System.out.println("Грузовик " + truck.getName() + " отправлен на маршрут.");
    }

    @Override
    public void startRepair() {
        System.out.println("Грузовик уже в ремонте. ");
    }
}




