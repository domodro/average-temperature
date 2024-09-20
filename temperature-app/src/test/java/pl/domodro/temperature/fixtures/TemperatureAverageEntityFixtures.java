package pl.domodro.temperature.fixtures;

import pl.domodro.temperature.persistence.TemperatureAverage;
import pl.domodro.temperature.persistence.TemperatureAverageId;

import java.util.Set;

public class TemperatureAverageEntityFixtures {
    public static final String CITY_1 = "Warszawa";
    public static final String CITY_2 = "Poznań";
    public static final String YEAR_1 = "2022";
    public static final String YEAR_2 = "2023";
    public static final String YEAR_3 = "2024";
    public static final Double TEMPERATURE_1 = 17.3;
    public static final Double TEMPERATURE_2 = 21.1;
    public static final Double TEMPERATURE_3 = -2.5;
    public static final Double TEMPERATURE_4 = 11.3;
    public static final Double TEMPERATURE_5 = 41.1;
    public static final Double TEMPERATURE_6 = -22.7;

    public static Set<TemperatureAverage> temperatureAverageFixtures() {
        return Set.of(
                temperatureAverageFixture(CITY_1, YEAR_1, TEMPERATURE_1),
                temperatureAverageFixture(CITY_1, YEAR_2, TEMPERATURE_2),
                temperatureAverageFixture(CITY_1, YEAR_3, TEMPERATURE_3),
                temperatureAverageFixture(CITY_2, YEAR_1, TEMPERATURE_4),
                temperatureAverageFixture(CITY_2, YEAR_2, TEMPERATURE_5),
                temperatureAverageFixture(CITY_2, YEAR_3, TEMPERATURE_6)
        );
    }

    public static TemperatureAverage temperatureAverageFixture(String city, String year, Double temperature) {
        return TemperatureAverage.builder()
                .id(new TemperatureAverageId(city, year))
                .temperature(temperature)
                .build();
    }
}
