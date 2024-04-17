package fr.harvest.temptracking.infrastrecture.repository;


import fr.harvest.temptracking.domain.TemperatureHistory;
import fr.harvest.temptracking.infrastrecture.entity.TemperatureHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemperatureHistoryRepository extends JpaRepository<TemperatureHistoryEntity, Long> {

    List<TemperatureHistory> findTop15ByOrderByIdDesc();
}
