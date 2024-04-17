package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import fr.harvest.temptracking.domain.TemperatureHistory;
import fr.harvest.temptracking.domain.port.TemperatureCaptor;
import fr.harvest.temptracking.infrastrecture.adapter.DatabaseAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TemperatureMeasurementUseCaseTest {
    private Sensor sensor;
    private DatabaseAdapter databaseAdapter;
    private TemperatureCaptor temperatureCaptor;
    private TemperatureMeasurementUseCase useCase;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        sensor = mock(Sensor.class);
        databaseAdapter = mock(DatabaseAdapter.class);
        temperatureCaptor = mock(TemperatureCaptor.class);
        // Initialize the use case with the mocked dependencies
        useCase = new TemperatureMeasurementUseCase(sensor, databaseAdapter, temperatureCaptor);
    }

    @Test
    void testExecute() {
        // Setup
        double temperature = 25.0;
        when(temperatureCaptor.getTemperature()).thenReturn(temperature);
        when(sensor.determineState(temperature)).thenReturn("WARM");

        // Execute
        String state = useCase.execute();

        // Verify
        assertEquals("WARM", state);
        verify(sensor).determineState(temperature);
        verify(temperatureCaptor, times(2)).getTemperature();  // S'attend maintenant à deux appels
        verify(databaseAdapter).saveTemperatureHistory(argThat(history ->
                history.getTemperature() == temperature &&
                        Math.abs(history.getTimestamp().until(LocalDateTime.now(), ChronoUnit.SECONDS)) < 1
        ));
    }

    @Test
    void testGetTemperatureHistory() {
        // Setup expected results
        List<TemperatureHistory> expectedHistory = Arrays.asList(
                new TemperatureHistory(25.0, LocalDateTime.now()),
                new TemperatureHistory(26.0, LocalDateTime.now())
        );
        when(databaseAdapter.getTemperatureHistory()).thenReturn(expectedHistory);

        // Execute
        List<TemperatureHistory> history = useCase.getTemperatureHistory();

        // Verify
        assertEquals(expectedHistory, history);
        verify(databaseAdapter).getTemperatureHistory();
    }

    @Test
    void testSetThresholds() {
        // Setup thresholds
        double hot = 30.0;
        double cold = 10.0;

        // Execute
        useCase.setThresholds(hot, cold);

        // Verify
        verify(sensor).updateStateThresholds(hot, cold);
    }
}