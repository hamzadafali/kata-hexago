package fr.harvest.temptracking.infrastrecture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //todo UUID
    private Long id;

    private double temperature;
    private LocalDateTime timestamp;

    public TemperatureHistoryEntity(double temperature, LocalDateTime timestamp) {
        this.temperature = temperature;
        this.timestamp = timestamp;
    }
}
