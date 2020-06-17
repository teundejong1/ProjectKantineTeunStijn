/**
 * class Docent - Deze klasse is voor de klant Docent.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 03/06/2020.
 */
public class Docent extends Persoon implements KortingskaartHouder {
    private String afkorting;
    private String afdeling;

    /**
     * Constructor van de klasse Docent.
     *
     * @param bsn           van de docent.
     * @param voornaam      van de docent.
     * @param achternaam    van de docent.
     * @param geboortedatum van de docent.
     * @param geslacht      van de docent.
     * @param afdeling      van de docent
     * @param afkorting     van de docent
     */
    public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String afkorting, String afdeling) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    /**
     * Lege constructor voor de klasse Docent.
     */
    public Docent() {

    }

    /**
     * Publieke Getter voor de afkorting van de docent.
     *
     * @return afkorting van docent.
     */
    public String getAfkorting() {
        return afkorting;
    }

    /**
     * Publieke Setter voor afkorting van de docent.
     *
     * @param afkorting van de docent.
     */
    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    /**
     * Publieke Getter voor de afdeling van de docent.
     *
     * @return afdeling van docent
     */
    public String getAfdeling() {
        return afdeling;
    }

    /**
     * Publieke Setter voor de afdeling van de docent.
     *
     * @param afdeling van de docent.
     */
    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    /**
     * Deze methode geeft het kortingspercentage van de klasse docent terug.
     *
     * @return 0.25
     */
    @Override
    public double geefKortingsPercentage() {
        return 0.25;
    }

    /**
     * Deze methode checkt of er een maximum is.
     *
     * @return een boolean true wanneer er een maximum is.
     */
    @Override
    public boolean heeftMaximum() {
        return true;
    }

    /**
     * Deze methode geeft de maximale korting terug.
     *
     * @return het maximum, 1.
     */
    @Override
    public double geefMaximum() {
        return 1;
    }
}
