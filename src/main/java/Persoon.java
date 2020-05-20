import java.util.*;
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
    private String geboortedatum; //Datum
    private char geslacht;

    /**
     * Constructor van de klasse Persoon.
     */

    public Persoon(int bsn, String voornaam, String achternaam, String geboortedatum, char geslacht) {
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
        geboortedatum = "0-0-0";
        geslacht = 'o';


    }
    /**
     * Getter voor het geslacht van de persoon.
     * @return geslacht van persoon.
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

        return " ";
    }
    /**
     * Setter voor bsn nummer.
     * @param bsn bsn nummer.
     */
    public void setBsn ( int bsn){
        this.bsn = bsn;
    }
    /**
     * Setter voor voornaam.
     * @param voornaam voornaam van persoon.
     */
    public void setVoornaam (String voornaam){
        this.voornaam = voornaam;
    }
    /**
     * Setter voor achternaam.
     * @param achternaam achternaam van persoon.
     */
    public void setAchternaam (String achternaam){
        this.achternaam = achternaam;
    }
    /**
     * Setter voor geboortedatum.
     * @param geboortedatum geboortedatum van persoon.
     */
    public void setGeboortedatum (String geboortedatum){
        this.geboortedatum = geboortedatum;
    }
    /**
     * Setter voor het geslacht.
     * @param geslacht geslacht van persoon
     */
    public void setGeslacht ( char geslacht){
        checkGeslacht(geslacht);
        this.geslacht = geslacht;
    }
    /**
     * Controleerd of het geslacht bestaat.
     * @param geslacht geslacht van persoon.
     * @return of het geslacht geldig is.
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
     * @return bsn nummer.
     */
    public int getBsn() {
        return bsn;
    }
    /**
     * Getter voor de voornaam van de persoon.
     * @return voornaam persoon.
     */
    public String getVoornaam() {
        return voornaam;
    }
    /**
     * Getter voor de achternaam van de persoon.
     * @return achternaam persoon.
     */
    public String getAchternaam() {
        return achternaam;
    }
    /**
     * Getter voor geboortedatum van de persoon, met controle of datum bekend is.
     * @return geboortedatum persoon.
     */
    public String getGeboortedatum() {
        if(!Datum.getDatumAsString().equals("0-0-0")) {
            geboortedatum = Datum.getDatumAsString();
        }else
         geboortedatum = "onbekend";
        return geboortedatum;
    }
    /**
     * omzetten van alle gegevens van een persoon in een string.
     * @return alle gegevens van persoon.
     */
    public String toString(){//overriding the toString() method
        return bsn+" "+voornaam + " " +achternaam + " " + geboortedatum + " " + geslacht;
    }
}