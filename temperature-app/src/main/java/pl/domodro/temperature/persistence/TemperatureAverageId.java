package pl.domodro.temperature.persistence;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TemperatureAverageId implements Serializable {
        private String city;
        private String year;
}
