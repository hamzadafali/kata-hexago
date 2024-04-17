package fr.harvest.temptracking.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {
    private Sensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new Sensor(40.0, 22.0);  // Initialiser avec les seuils HOT à 40 et COLD à 22
    }

    @Test
    void testDetermineStateHot() {
        assertEquals("HOT", sensor.determineState(40.0), "Sensor should be HOT at 40.0°C");
        assertEquals("HOT", sensor.determineState(45.0), "Sensor should be HOT above 40.0°C");
    }

    @Test
    void testDetermineStateCold() {
        assertEquals("COLD", sensor.determineState(21.0), "Sensor should be COLD at 22.0°C");
        assertEquals("COLD", sensor.determineState(18.0), "Sensor should be COLD below 22.0°C");
    }

    @Test
    void testDetermineStateWarm() {
        assertEquals("WARM", sensor.determineState(30.0), "Sensor should be WARM at 30.0°C");
        assertEquals("WARM", sensor.determineState(39.9), "Sensor should be WARM just below 40.0°C");
    }

    @Test
    void testUpdateStateThresholds() {
        sensor.updateStateThresholds(50.0, 20.0);
        assertEquals("HOT", sensor.determineState(51.0), "Sensor should be HOT at the new threshold of 50.0°C");
        assertEquals("COLD", sensor.determineState(19.0), "Sensor should be COLD at the new threshold of 20.0°C");
    }
}