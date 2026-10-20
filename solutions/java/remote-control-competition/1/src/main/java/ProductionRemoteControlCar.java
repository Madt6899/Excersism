class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int numero = 0;
    private int distancia=0;
    @Override
    public void drive() {
        this.distancia+=10;
    }
    @Override
    public int getDistanceTravelled() {
        return this.distancia;
    }

    public int getNumberOfVictories() {
        return this.numero;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numero=numberOfVictories;
    }
    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        return Integer.compare(otherCar.getNumberOfVictories(), this.numero);
    }
}
