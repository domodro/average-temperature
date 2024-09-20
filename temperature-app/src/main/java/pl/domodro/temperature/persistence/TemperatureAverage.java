package pl.domodro.temperature.persistence;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TemperatureAverage {
        @EmbeddedId
        private TemperatureAverageId id;
        private Double temperature;
}
