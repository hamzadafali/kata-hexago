package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateThresholdsUseCase {
    private final Sensor sensor;

    @Autowired
    public UpdateThresholdsUseCase(Sensor sensor) {
        this.sensor = sensor;
    }

    public void updateThresholds(double hotThreshold, double coldThreshold) {
        sensor.updateStateThresholds(hotThreshold, coldThreshold);
    }
}
