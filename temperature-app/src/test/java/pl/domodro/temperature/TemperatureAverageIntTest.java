package pl.domodro.temperature;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.domodro.temperature.model.YearTemperature;
import pl.domodro.temperature.persistence.TemperatureAverageRepository;
import pl.domodro.temperature.service.TemperatureAverageService;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.domodro.temperature.fixtures.TemperatureAverageEntityFixtures.*;

class TemperatureAverageIntTest extends AbstractIntTest {

    @Autowired
    private TemperatureAverageRepository temperatureAverageRepository;

    @Autowired
    private TemperatureAverageService temperatureAverageService;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        temperatureAverageRepository.deleteAll();
    }

    @Test
    void shouldReturnTemperaturesForCity() {
        temperatureAverageRepository.saveAll(temperatureAverageFixtures());
        var result = given()
                .contentType(ContentType.JSON)
                .pathParam("city", CITY_1)
                .when()
                .get("/temperature/city/{city}")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", YearTemperature.class);

        assertThat(result).hasSize(3);
        assertThat(result).containsExactlyInAnyOrder(
                new YearTemperature().year(YEAR_1).averageTemperature(TEMPERATURE_1),
                new YearTemperature().year(YEAR_2).averageTemperature(TEMPERATURE_2),
                new YearTemperature().year(YEAR_3).averageTemperature(TEMPERATURE_3));
    }
}
