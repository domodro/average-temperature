package pl.domodro.temperature.mapper;

import org.springframework.stereotype.Component;
import pl.domodro.temperature.model.YearTemperature;
import pl.domodro.temperature.persistence.TemperatureAverage;

@Component
public class YearTemperatureMapper {
    public YearTemperature map(TemperatureAverage source) {
        return new YearTemperature()
                .year(source.getId().getYear())
                .averageTemperature(source.getTemperature());
    }
}
