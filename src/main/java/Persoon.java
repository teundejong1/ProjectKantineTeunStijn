import java.util.Objects;

public class Persoon {
    private int bsn;
    private String voornaam;
    private String achternaam;
    private String geboortedatum;
    private char geslacht;

    public Persoon(int bsn, String voornaam, String achternaam, String geboortedatum, char geslacht) {
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        if (checkGeslacht(geslacht)) {
            this.geslacht = geslacht;
        } else {
            System.out.println(geslacht + "Dit is geen geldig geslacht");
        }
    }

    public Persoon(){
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;// jouw code STIJN
        this.geslacht = 'o';

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
        this.geslacht = geslacht;

    }
    private boolean checkGeslacht ( char geslacht){
        return geslacht == 'M' || geslacht == 'm' || geslacht == 'V' || geslacht == 'v';
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
        if(Datum.bestaatDatum()= 1) {
            geboortedatum = Datum.getDatumAsString();
        }else
         geboortedatum = "onbekend";
        return geboortedatum;
    }
}