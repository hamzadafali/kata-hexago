package fr.harvest.temptracking.application.usecase;

import fr.harvest.temptracking.domain.Sensor;
import fr.harvest.temptracking.domain.port.TemperatureCaptor;
import fr.harvest.temptracking.domain.TemperatureHistory;
import fr.harvest.temptracking.infrastrecture.adapter.DatabaseAdapter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemperatureMeasurementUseCase {
    private final Sensor sensor;
    private final DatabaseAdapter databaseAdapter;
    private final TemperatureCaptor temperatureCaptor;

    public TemperatureMeasurementUseCase(Sensor sensor, DatabaseAdapter databaseAdapter, TemperatureCaptor temperatureCaptor) {
        this.sensor = sensor;
        this.databaseAdapter = databaseAdapter;
        this.temperatureCaptor = temperatureCaptor;
    }

    public String execute() {

        String state = sensor.determineState(temperatureCaptor.getTemperature());
        databaseAdapter.saveTemperatureHistory(new TemperatureHistory(temperatureCaptor.getTemperature(), LocalDateTime.now()));
        return state;
    }

    public List<TemperatureHistory> getTemperatureHistory() {
        return databaseAdapter.getTemperatureHistory();
    }

    public void setThresholds(double hot, double cold) {
        sensor.updateStateThresholds(hot, cold);
    }


}
