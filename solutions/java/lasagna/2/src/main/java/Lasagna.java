public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int actualMinutes){
        return expectedMinutesInOven()-actualMinutes;
    }

    public int preparationTimeInMinutes(int capas){
        return capas*2;
    }

    public int totalTimeInMinutes(int capas, int actualMinutes){
        int tiempo=preparationTimeInMinutes(capas)+actualMinutes;
        return tiempo;
    }
}
