package horoscope;

import horoscope.pojo.Horoscope;
import horoscope.service.Service;
import horoscope.utils.Signe;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SigneControleur {

	private final Service service;

	@GetMapping("/signe/{dateNaissance}")
	public String getSigne(
			@PathVariable("dateNaissance") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateNaissance) {

		return service.calculerSigne(dateNaissance).getNom();
	}

	@GetMapping("/{signe}")
	public Horoscope horoscope(@PathVariable("signe") Signe signe) {

		return service.calculerHoroscope(signe, LocalDate.now());
	}

	@GetMapping("/{signe}/{date}")
	public Horoscope horoscope(@PathVariable("signe") Signe signe,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		return service.calculerHoroscope(signe, date);
	}

	public SigneControleur(Service service) {
		this.service = service;
	}

}
