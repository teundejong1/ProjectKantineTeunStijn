import java.time.LocalDate;
import java.util.Objects;

/**
 * class Persoon - Deze klasse houdt de gegevens bij van een persoon.
 *
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */

public class Persoon {
    private int bsn;
    private String voornaam;
    private String achternaam;
    private LocalDate geboortedatum;
    private char geslacht;
    private Betaalwijze betaalwijze;

    /**
     * Constructor van de klasse Persoon.
     *
     * @param bsn           van de klant.
     * @param voornaam      van de klant.
     * @param achternaam    van de klant.
     * @param geboortedatum van de klant.
     * @param geslacht      van de klant.
     */
    public Persoon(int bsn, String voornaam, String achternaam, LocalDate geboortedatum, char geslacht) {
        setBsn(bsn);
        setVoornaam(voornaam);
        setAchternaam(achternaam);
        setGeboortedatum(geboortedatum);
        if (checkGeslacht(geslacht)) {
            setGeslacht(geslacht);
        } else {
            System.out.println(geslacht + "Dit is geen geldig geslacht");
        }
    }

    /**
     * parameter-loze constructor van de klasse Persoon.
     */
    public Persoon() {
        bsn = 0;
        voornaam = "";
        achternaam = "";
        LocalDate Datum = LocalDate.of(2019, 5, 16);
        geslacht = 'o';
    }

    /**
     * publieke Getter voor het geslacht van de persoon.
     *
     * @return geslacht van persoon, type String.
     */

    public String getGeslacht() {

        if (checkGeslacht(geslacht)) { //Check geslacht
            String strGeslacht = String.valueOf(geslacht);
            strGeslacht = strGeslacht.toUpperCase();
            if (Objects.equals(strGeslacht, "M")) {
                strGeslacht = "Man";
            } else if (Objects.equals(strGeslacht, "V")) {
                strGeslacht = "Vrouw";
            } else {
                strGeslacht = "Onbekend";
            }
            return strGeslacht;
        }

        return "";
    }

    /**
     * Publieke Setter voor het geslacht.
     *
     * @param geslacht geslacht van persoon, type char.
     */
    public void setGeslacht(char geslacht) {
        checkGeslacht(geslacht);
        this.geslacht = geslacht;
    }

    /**
     * Private methode.
     * Controleerd of het geslacht bestaat.
     *
     * @param geslacht geslacht van persoon, type char.
     * @return true als geldig geslacht, anders false.
     */
    private boolean checkGeslacht(char geslacht) {
        if (geslacht == 'M') {
            return true;
        } else if (geslacht == 'm') {
            return true;
        } else if (geslacht == 'V') {
            return true;
        } else if (geslacht == 'v') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Publieke Getter voor bsn van de persoon.
     *
     * @return bsn nummer, type int.
     */
    public int getBsn() {
        return bsn;
    }

    /**
     * publieke Setter voor bsn nummer.
     *
     * @param bsn bsn nummer, type int.
     */
    public void setBsn(int bsn) {
        this.bsn = bsn;
    }

    /**
     * Publieke Getter voor de voornaam van de persoon.
     *
     * @return voornaam persoon, type String.
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Publieke Setter voor voornaam.
     *
     * @param voornaam voornaam van persoon, type String.
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * Publieke Getter voor de achternaam van de persoon.
     *
     * @return achternaam persoon, type String.
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Publieke Setter voor achternaam.
     *
     * @param achternaam achternaam van persoon, type String.
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * Publieke Getter voor geboortedatum van de persoon, met controle of datum bekend is.
     *
     * @return geboortedatum persoon, type Datum.
     */
    public LocalDate getGeboortedatum() {
//        if (geboortedatum.getDatumAsString().equals("0-0-0")) {
//            return "Onbekend";
//        } else
//            return geboortedatum.getDatumAsString();
        return geboortedatum;
    }

    /**
     * Publieke Setter voor geboortedatum.
     *
     * @param geboortedatum geboortedatum van persoon, type Datum.
     */
    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    /**
     * Publieke toString methode
     *
     * @return student, als instantie van student
     * docent, als instantie van docent
     * kantinemedewerker, als geen student of docent.
     */
    @Override
    public String toString() {
        if (this instanceof Student) {
            return "Student";
        } else if (this instanceof Docent) {
            return "Docent";
        } else {
            return "Kantine Medewerker";
        }
    }

    /**
     * Publieke methode om de betaalwijze op te vragen.
     *
     * @return betaalwijze, type betaalwijze.
     */
    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    /**
     * Publieke methode om de betaalwijze te setten.
     *
     * @param betaalwijze van het type betaalwijze.
     */
    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }
}