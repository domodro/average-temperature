package pl.domodro.temperature.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import pl.domodro.temperature.model.YearTemperature;
import pl.domodro.temperature.service.TemperatureAverageService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class TemperatureController implements TemperatureApi {
    private final TemperatureAverageService temperatureAverageService;

    @Override
    public Mono<ResponseEntity<Flux<YearTemperature>>> getTemperature(String city, ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok(
                Flux.just(city)
                        .flatMap(temperatureAverageService::getAverageTemperaturesForCity)
        ));
    }
}
