package horoscope.pojo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record Note(@Min(1) @Max(5) int valeur) {

}