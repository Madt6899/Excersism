class NeedForSpeed {
    public int getSpeed() {
        return this.speed;
    }
    public int getBatteryDrain() {
        return this.batteryDrain;
    }
    private int speed;
    private int batteryDrain;
    private int battery = 100;
    private int distance = 0;
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this.battery < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distance;
    }

    public void drive() {
        if(battery >= batteryDrain){
            this.distance = this.distance + this.speed;
            this.battery = this.battery - this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;
    RaceTrack(int distance) {
    this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int maxDrives = 100 / car.getBatteryDrain();
        int maxDistance = maxDrives * car.getSpeed();
        return maxDistance >= this.distance;
    }
}
