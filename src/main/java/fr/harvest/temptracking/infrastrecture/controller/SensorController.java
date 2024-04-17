package fr.harvest.temptracking.infrastrecture.controller;

import fr.harvest.temptracking.application.usecase.TemperatureMeasurementUseCase;
import fr.harvest.temptracking.domain.TemperatureHistory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    private final TemperatureMeasurementUseCase service;

    public SensorController(TemperatureMeasurementUseCase service) {
        this.service = service;
    }


    @GetMapping("/state")
    public String getSensorState() {
        return service.execute();
    }

    @GetMapping("/history")
    //ResponseEntity
    public List<TemperatureHistory> getTemperatureHistory() {
        return service.getTemperatureHistory();
    }

    @PostMapping("/thresholds")
    public void setThresholds(@RequestParam double hot, @RequestParam double cold) {
        service.setThresholds(hot, cold);
    }
}