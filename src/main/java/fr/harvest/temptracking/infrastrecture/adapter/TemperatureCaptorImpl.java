package fr.harvest.temptracking.infrastrecture.adapter;

import fr.harvest.temptracking.domain.port.TemperatureCaptor;
import org.springframework.stereotype.Service;

@Service
public class TemperatureCaptorImpl implements TemperatureCaptor {
    @Override
    public double getTemperature() {
        return 10.0;
    }
}
