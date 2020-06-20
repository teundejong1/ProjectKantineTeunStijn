import java.time.LocalDate;

/**
 * class KantineMedewerker - Deze klasse is voor de medewerkers in de kantine.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 02/06/2020.
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder {
    private int medewerkersnummer;
    private boolean toestaanKasasa;

    /**
     * Constructor van de klasse Persoon.
     *
     * @param bsn               van de medewerker.
     * @param voornaam          van de medewerker.
     * @param achternaam        van de medewerker.
     * @param geboortedatum     van de medewerker.
     * @param geslacht          van de medewerker.
     * @param medewerkersnummer van de medewerker.
     * @param toestaanKasasa    is de medewerker bevoegd om de kassa te gebruiken.
     */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, LocalDate geboortedatum, char geslacht, int medewerkersnummer, boolean toestaanKasasa) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.toestaanKasasa = toestaanKasasa;
    }

    /**
     * Lege constructor voor de klasse KantineMedewerkwer.
     */
    public KantineMedewerker() {

    }

    /**
     * Publieke Getter voor medewerkersnummer van de medewerker.
     *
     * @return het medewerkersnummer
     */
    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    /**
     * Publieke setter voor medewerkersnummer van de medewerker.
     *
     * @param medewerkersnummer van de medewerker.
     */
    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    /**
     * Publieke Getter voor bevoegdheid van de medewerker.
     *
     * @return bevoegdheid van de medewerker
     */
    public boolean isToestaanKasasa() {
        return toestaanKasasa;
    }

    /**
     * Publieke Setter voor bevoegdheid van medewerker.
     *
     * @param toestaanKasasa is de medewerker bevoegd om de kassa te gebruiken.
     */
    public void setToestaanKasasa(boolean toestaanKasasa) {
        this.toestaanKasasa = toestaanKasasa;
    }

    /**
     * Deze methode geeft het kortingspercentage van de klasse docent terug.
     *
     * @return 0.35
     */
    @Override
    public double geefKortingsPercentage() {
        return 0.35;
    }

    /**
     * Deze methode checkt of er een maximum is.
     *
     * @return een boolean true wanneer er een maximum is.
     */
    @Override
    public boolean heeftMaximum() {
        return false;
    }

    /**
     * Deze methode geeft de maximale korting terug.
     *
     * @return het maximum, 0.
     */
    @Override
    public double geefMaximum() {
        return 0;
    }
}
