package pl.domodro.temperature.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.domodro.temperature.mapper.YearTemperatureMapper;
import pl.domodro.temperature.model.YearTemperature;
import pl.domodro.temperature.persistence.TemperatureAverageRepository;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class TemperatureAverageService {
    private final TemperatureAverageRepository temperatureAverageRepository;
    private final YearTemperatureMapper yearTemperatureMapper;

    public Flux<YearTemperature> getAverageTemperaturesForCity(String city) {
        return Flux.fromStream(temperatureAverageRepository.findAllByIdCityIgnoreCase(city).stream())
                .map(yearTemperatureMapper::map);
    }
}
