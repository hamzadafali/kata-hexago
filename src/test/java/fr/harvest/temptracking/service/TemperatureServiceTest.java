//package fr.harvest.temptracking.service;
//
//import fr.harvest.temptracking.entity.TemperatureHistory;
//import fr.harvest.temptracking.repository.TemperatureHistoryRepository;
//import fr.harvest.temptracking.utils.Sensor;
//import fr.harvest.temptracking.utils.TemperatureCaptor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class TemperatureServiceTest {
//
//
//    @Mock
//    private Sensor sensor;
//
//    @Mock
//    private TemperatureCaptor captor;
//
//    @Mock
//    private TemperatureHistoryRepository repository;
//
//    @InjectMocks
//    private TemperatureService service;
//
//    @BeforeEach
//    void setUp() {
//        when(sensor.getCaptor()).thenReturn(captor);
//        when(captor.getTemperature()).thenReturn(25.0);  // Supposons que cela mène à un état "WARM"
//        when(repository.save(any(TemperatureHistory.class))).thenReturn(new TemperatureHistory());
//    }
//
//    @Test
//    void testGetCurrentStateWarm() {
//        String currentState = service.getCurrentState();
//        assertEquals("WARM", currentState);
//    }
//
//}