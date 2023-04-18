package horoscope.utils;

import static horoscope.service.Service.ANNEE_DEFAULT;

import java.time.LocalDate;

/**
 * Date officielle prise dans wikipédia :
 * https://fr.wikipedia.org/wiki/Signe_du_zodiaque
 *
 * DATE TROPICALE calendrier Grégorien
 */
public enum Signe {

	BELIER("Bélier", LocalDate.of(ANNEE_DEFAULT, 3, 21), LocalDate.of(ANNEE_DEFAULT, 4, 20)),
	TAUREAU("Taureau", LocalDate.of(ANNEE_DEFAULT, 4, 21), LocalDate.of(ANNEE_DEFAULT, 5, 20)),
	GEMEAUX("Gémeaux", LocalDate.of(ANNEE_DEFAULT, 5, 21), LocalDate.of(ANNEE_DEFAULT, 6, 21)),
	CANCER("Cancer", LocalDate.of(ANNEE_DEFAULT, 6, 22), LocalDate.of(ANNEE_DEFAULT, 7, 22)),
	LION("Lion", LocalDate.of(ANNEE_DEFAULT, 7, 23), LocalDate.of(ANNEE_DEFAULT, 8, 22)),
	VIERGE("Vierge", LocalDate.of(ANNEE_DEFAULT, 8, 23), LocalDate.of(ANNEE_DEFAULT, 9, 22)),
	BALANCE("Balance", LocalDate.of(ANNEE_DEFAULT, 9, 23), LocalDate.of(ANNEE_DEFAULT, 10, 22)),
	SCORPION("Scorpion", LocalDate.of(ANNEE_DEFAULT, 10, 23), LocalDate.of(ANNEE_DEFAULT, 11, 22)),
	SAGITTAIRE("Sagittaire", LocalDate.of(ANNEE_DEFAULT, 11, 23), LocalDate.of(ANNEE_DEFAULT, 12, 21)),
	VERSEAU("Verseau", LocalDate.of(ANNEE_DEFAULT, 1, 21), LocalDate.of(ANNEE_DEFAULT, 2, 19)),
	POISSONS("Poissons", LocalDate.of(ANNEE_DEFAULT, 2, 19), LocalDate.of(ANNEE_DEFAULT, 3, 20)),
	// capricorne cas particulier -> donc retour par défaut donc on ne mets exprès
	// pas les bonnes dates
	CAPRICORNE("Capricorne", LocalDate.of(ANNEE_DEFAULT, 12, 31), LocalDate.of(ANNEE_DEFAULT, 12, 1));

	private String nom;
	private LocalDate debut;
	private LocalDate fin;

	Signe(String nom, LocalDate debut, LocalDate fin) {
		this.nom = nom;
		this.debut = debut;
		this.fin = fin;
	}

	public String getNom() {
		return nom;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public LocalDate getFin() {
		return fin;
	}
}
