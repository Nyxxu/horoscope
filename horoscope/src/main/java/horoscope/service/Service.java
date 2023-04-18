package horoscope.service;

import horoscope.pojo.Horoscope;
import horoscope.utils.Signe;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Stream;

@org.springframework.stereotype.Service
public class Service {

	public static final int ANNEE_DEFAULT = 2000;

	public Signe calculerSigne(LocalDate dateNaissance) {

		final var dateTransformee = dateNaissance.withYear(ANNEE_DEFAULT);

		return Stream.of(Signe.values())
				.filter(x -> x.getDebut().isBefore(dateTransformee) || x.getDebut().isEqual(dateTransformee)) //
				.filter(x -> x.getFin().isAfter(dateTransformee) || x.getFin().isEqual(dateTransformee)) //
				.findFirst() //
				.orElse(Signe.CAPRICORNE);
	}

	public Horoscope calculerHoroscope(Signe signe, LocalDate date) {

		final var bundle = ResourceBundle.getBundle("citations", Locale.forLanguageTag(signe.name()));
		final var texte = bundle.getString("" + date.getDayOfMonth());

		return new Horoscope(signe, date, texte);
	}
}
