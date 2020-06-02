/**
 * class KantineMedewerker - Deze klasse is voor de medewerkers in de kantine.
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 02/06/2020.
 */
public class KantineMedewerker extends Persoon {
    private int medewerkersnummer;
    private boolean toestaanKasasa;

    /**
     * Constructor van de klasse Persoon.
     * @param bsn van de medewerker.
     * @param voornaam van de medewerker.
     * @param achternaam van de medewerker.
     * @param geboortedatum van de medewerker.
     * @param geslacht van de medewerker.
     * @param medewerkersnummer van de medewerker.
     * @param toestaanKasasa is de medewerker bevoegd om de kassa te gebruiken.
     */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersnummer, boolean toestaanKasasa) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.toestaanKasasa = toestaanKasasa;
    }
    /**
     * Getter voor medewerkersnummer van de medewerker.
     * @return het medewerkersnummer
     */
    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }
    /**
     * setter voor medewerkersnummer van de medewerker.
     * @param medewerkersnummer van de medewerker.
     */
    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }
    /**
     * Getter voor bevoegdheid van de medewerker.
     * @return bevoegdheid van de medewerker
     */
    public boolean isToestaanKasasa() {
        return toestaanKasasa;
    }
    /**
     * Setter voor bevoegdheid van medewerker.
     * @param toestaanKasasa is de medewerker bevoegd om de kassa te gebruiken.
     */
    public void setToestaanKasasa(boolean toestaanKasasa) {
        this.toestaanKasasa = toestaanKasasa;
    }
}
