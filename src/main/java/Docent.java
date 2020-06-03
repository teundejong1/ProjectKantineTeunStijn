/**
 * class Docent - Deze klasse is voor de klant Docent.
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 03/06/2020.
 */
public class Docent extends Persoon {
    private String afkorting;
    private String afdeling;

    /**
     * Constructor van de klasse Docent.
     * @param bsn van de docent.
     * @param voornaam van de docent.
     * @param achternaam van de docent.
     * @param geboortedatum van de docent.
     * @param geslacht van de docent.
     * @param afdeling van de docent
     * @param  afkorting van de docent
     */
    public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String afkorting, String afdeling) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }
    /**
     * Getter voor de afkorting van de docent.
     * @return afkorting van docent.
     */
    public String getAfkorting() {
        return afkorting;
    }
    /**
     * setter voor afkorting van de docent.
     * @param afkorting van de docent.
     */
    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }
    /**
     * Getter voor de afdeling van de docent.
     * @return afdeling van docent
     */
    public String getAfdeling() {
        return afdeling;
    }
    /**
     * setter voor de afdeling van de docent.
     * @param afdeling van de docent.
     */
    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }
}
