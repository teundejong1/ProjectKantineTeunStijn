import java.util.Objects;
/**
 * class Persoon - Deze klasse houdt de gegevens bij van een persoon.
 * @author Teun de Jong en Stijn Wolthuis.
 * @version 19/05/2020.
 */

public class Persoon {
    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;

    /**
     * Constructor van de klasse Persoon.
     */

    public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
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
     * parameter-loze constructor van de klasse Datum.
     */
    public Persoon(){
        bsn = 0;
        voornaam = "voornaam";
        achternaam = "achternaam";
        geboortedatum = new Datum();
        geslacht = 'o';


    }
    /**
     * Getter voor het geslacht van de persoon.
     * @return geslacht van persoon, type String.
     */

    public String getGeslacht () {

        if (checkGeslacht(geslacht)) {
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
     * Setter voor bsn nummer.
     * @param bsn bsn nummer, type int.
     */
    public void setBsn ( int bsn){
        this.bsn = bsn;
    }

    /**
     * Setter voor voornaam.
     * @param voornaam voornaam van persoon, type String.
     */
    public void setVoornaam (String voornaam){
        this.voornaam = voornaam;
    }

    /**
     * Setter voor achternaam.
     * @param achternaam achternaam van persoon, type String.
     */
    public void setAchternaam (String achternaam){
        this.achternaam = achternaam;
    }

    /**
     * Setter voor geboortedatum.
     * @param geboortedatum geboortedatum van persoon, type Datum.
     */
    public void setGeboortedatum (Datum geboortedatum){
        this.geboortedatum = geboortedatum;
    }

    /**
     * Setter voor het geslacht.
     * @param geslacht geslacht van persoon, type char.
     */
    public void setGeslacht ( char geslacht){
        checkGeslacht(geslacht);
        this.geslacht = geslacht;
    }

    /**
     * Controleerd of het geslacht bestaat.
     * @param geslacht geslacht van persoon, type char.
     * @return true als geldig geslacht, anders false.
     */
    private boolean checkGeslacht ( char geslacht){
         if (geslacht == 'M') {
             return true;
         }
         else if (geslacht == 'm') {
             return true;
         }
         else if (geslacht == 'V') {
             return true;
         }
         else if (geslacht == 'v') {
             return true;
         }
         else {
            return false;
         }
    }

    /**
     * Getter voor bsn van de persoon.
     * @return bsn nummer, type int.
     */
    public int getBsn() {
        return bsn;
    }

    /**
     * Getter voor de voornaam van de persoon.
     * @return voornaam persoon, type String.
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Getter voor de achternaam van de persoon.
     * @return achternaam persoon, type String.
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Getter voor geboortedatum van de persoon, met controle of datum bekend is.
     * @return geboortedatum persoon, type Datum.
     */
    public String getGeboortedatum() {
        if(geboortedatum.getDatumAsString().equals("0-0-0")){
            return "Onbekend";
        }   else
         return geboortedatum.getDatumAsString();
    }

    /**
     * omzetten van alle gegevens van een persoon in een String.
     * @return String met bsn nummer, voornaam, achternaam, geboortedatum en geslacht.
     */
    public String toString(){//overriding the toString() method
        return bsn+" "+voornaam + " " +achternaam + " " + geboortedatum + " " + geslacht;
    }
}