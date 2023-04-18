package horoscope;

import horoscope.pojo.Note;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class NoteControleur {

	private final List<Integer> notes = new ArrayList<>();

	@PostMapping("/note")
	public void noter(@Valid @RequestBody Note note) {
		notes.add(note.valeur());
	}

	@GetMapping("/note/reset")
	public void reset() {
		notes.clear();
	}

	@GetMapping("/note")
	public double moyenne() {

		final var moyenne = notes.stream().mapToInt(i -> i).average().orElse(0d);
		System.out.println("moyenne actuelle : " + moyenne);
		return moyenne;
	}

}
