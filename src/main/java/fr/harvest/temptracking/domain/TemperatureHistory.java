package fr.harvest.temptracking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class TemperatureHistory {

    private final double temperature;
    private final LocalDateTime timestamp;
}
