import java.util.*;

public class Persoon {
    private int bsn;
    private String voornaam;
    private String achternaam;
    private String geboortedatum;
    private char geslacht;

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

    public Persoon(){
        bsn = 0;
        voornaam = "voornaam";
        achternaam = "achternaam";
        geboortedatum = "0-0-0";
        geslacht = 'o';


    }

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

    public void setBsn ( int bsn){
        this.bsn = bsn;
    }

    public void setVoornaam (String voornaam){
        this.voornaam = voornaam;
    }

    public void setAchternaam (String achternaam){
        this.achternaam = achternaam;
    }

    public void setGeboortedatum (String geboortedatum){
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht ( char geslacht){
        checkGeslacht(geslacht);
        this.geslacht = geslacht;
    }

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

    public int getBsn() {
        return bsn;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getGeboortedatum() {
        if(!Datum.getDatumAsString().equals("0-0-0")) {
            geboortedatum = Datum.getDatumAsString();
        }else
         geboortedatum = "onbekend";
        return geboortedatum;
    }

    public String toString(){//overriding the toString() method
        return bsn+" "+voornaam + " " +achternaam + " " + geboortedatum + " " + geslacht;
    }
}