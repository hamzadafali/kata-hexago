package fr.harvest.temptracking.infrastrecture.adapter;

import fr.harvest.temptracking.domain.TemperatureHistory;
import fr.harvest.temptracking.infrastrecture.entity.TemperatureHistoryEntity;
import fr.harvest.temptracking.infrastrecture.repository.TemperatureHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseAdapter {
    private final TemperatureHistoryRepository repository;

    @Autowired
    public DatabaseAdapter(TemperatureHistoryRepository repository) {
        this.repository = repository;
    }

    public void saveTemperatureHistory(TemperatureHistory history) {
        TemperatureHistoryEntity entity = new TemperatureHistoryEntity(history.getTemperature(), history.getTimestamp());
        repository.save(entity);
    }

    public List<TemperatureHistory> getTemperatureHistory() {
        return repository.findTop15ByOrderByIdDesc();
    }
}
