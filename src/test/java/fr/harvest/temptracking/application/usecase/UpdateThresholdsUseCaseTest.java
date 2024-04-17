package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateThresholdsUseCaseTest {
    @Mock
    private Sensor sensor;

    private UpdateThresholdsUseCase updateThresholdsUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateThresholdsUseCase = new UpdateThresholdsUseCase(sensor);
    }

    @Test
    void testUpdateThresholds() {
        double hotThreshold = 35.0;
        double coldThreshold = 15.0;

        // Execute the method under test
        updateThresholdsUseCase.updateThresholds(hotThreshold, coldThreshold);

        // Verify that the sensor's updateStateThresholds method was called with the correct parameters
        verify(sensor).updateStateThresholds(hotThreshold, coldThreshold);
        verify(sensor, never()).determineState(25.0);
    }
}