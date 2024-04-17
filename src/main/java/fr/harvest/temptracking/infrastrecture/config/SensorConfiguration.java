package fr.harvest.temptracking.infrastrecture.config;

import fr.harvest.temptracking.domain.Sensor;
import fr.harvest.temptracking.domain.SensorState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SensorConfiguration {

    @Value("${sensor.hotThreshold}")
    private double hotThreshold;

    @Value("${sensor.coldThreshold}")
    private double coldThreshold;

    @Bean
    public Sensor sensor() {
        return new Sensor(hotThreshold, coldThreshold);
    }
}
