public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private int distancia=0;
    @Override
    public void drive() {
        this.distancia+=20;
    }
    @Override
    public int getDistanceTravelled() {
        return this.distancia;
    }
}