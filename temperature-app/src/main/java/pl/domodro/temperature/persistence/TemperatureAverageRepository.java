package pl.domodro.temperature.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TemperatureAverageRepository
        extends JpaRepository<TemperatureAverage, TemperatureAverageId> {

    Set<TemperatureAverage> findAllByIdCityIgnoreCase(String city);
}
