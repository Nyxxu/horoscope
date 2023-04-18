package horoscope.pojo;

import horoscope.utils.Signe;

import java.time.LocalDate;

public record Horoscope(Signe signe, LocalDate date, String texte) {
}