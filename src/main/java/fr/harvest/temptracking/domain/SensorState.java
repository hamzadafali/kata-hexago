package fr.harvest.temptracking.domain;

public class SensorState {
    private double hotThreshold;
    private double coldThreshold;

    public SensorState(double hotThreshold, double coldThreshold) {
        this.hotThreshold = hotThreshold;
        this.coldThreshold = coldThreshold;
    }

    public String determineState(double temperature) {
        if (temperature >= hotThreshold) {
            return "HOT";
        } else if (temperature < coldThreshold) {
            return "COLD";
        } else {
            return "WARM";
        }
    }

    public void updateThresholds(double hot, double cold) {
        this.hotThreshold = hot;
        this.coldThreshold = cold;
    }
}
